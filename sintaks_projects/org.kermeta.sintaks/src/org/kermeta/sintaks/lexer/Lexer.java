/*
 * Created on 18 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.lexer;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.kermeta.sintaks.sts.Root;
import org.kermeta.sintaks.sts.Terminal;


public class Lexer implements ILexer {
	
	static final private int INIT_STATE         = 0;
	static final private int TOKEN_STATE        = 1;
	static final private int STRING_STATE       = 2;
	static final private int EOLCOMMENT_STATE   = 3;
	static final private int BLOCKCOMMENT_STATE = 4;
	static final private int ESCAPEDCHAR_STATE  = 5;
	
	
	private Reader input;
	private StringBuffer current;
	private long position;
	private boolean eof;

	private List<Terminal> terminals;
	private List<Terminal> separators;

	private char stringDelimiter = '\"';
	private char escapeCharacter = '\\';
	private String eolComment = "//";
	private String blockCommentStart = "/*";
	private String blockCommentEnd = "*/";
	
	
	/**
	 * @param input
	 * @param stsRoot
	 */
	public Lexer(Reader input, Root stsRoot) {
		this.input = input;
		
		this.stringDelimiter = stsRoot.getStringDelimliter();
		this.escapeCharacter = stsRoot.getEscapeCharacter();
		this.eolComment = stsRoot.getEolComment();
		this.blockCommentStart = stsRoot.getBlockCommentStart();
		this.blockCommentEnd = stsRoot.getBlockCommentEnd();
		
		this.terminals  = new ArrayList<Terminal>();
		this.separators = new ArrayList<Terminal>();
		
		TreeIterator<EObject> i = stsRoot.eAllContents();
		while (i.hasNext()) {
			Object o = i.next();
			if (o instanceof Terminal) {
				Terminal terminal = (Terminal) o;
				terminals.add(terminal);
				if (terminal.isLexicalSeparator())
					separators.add(terminal);
			}
		}
	}

	
//	/**
//	 * @param input
//	 * @param res
//	 */
//	public Lexer(Reader input, List<String> terminals, List<String> separators) {
//		this.input = input;
//		this.separators = separators;
//		this.terminals = terminals;
//	}
	

	/* (non-Javadoc)
	 * @see lexer.ILexer#begin()
	 */
	public void begin () {
		position=0;
		try {
			input.mark(4096);
		} catch (IOException e) {
			e.printStackTrace();
		}
		next();
	}
	
	
	/* (non-Javadoc)
	 * @see lexer.ILexer#atEnd()
	 */
	public boolean atEnd() {
		boolean atEnd = false;
		
		if(current == null)
			atEnd = true;
		else if(current.toString().length() > 0) {
			atEnd = current.toString().charAt(0) == ((char) -1);
		}
		
		return atEnd;
	}
	

	/* (non-Javadoc)
	 * @see lexer.ILexer#get()
	 */
	public String get () {
		return current.toString();
	}
	

	/* (non-Javadoc)
	 * @see fr.irisa.triskell.kermeta.textloader.lexer.ILexer#getPosition()
	 */
	public long getPosition () {
		return position - current.length() - 1;
	}
	

	/* (non-Javadoc)
	 * @see lexer.ILexer#back(long position)
	 */
	public void back(long position) {
		if (position+current.length()+1  > this.position) {
			eof = true;
		}
		if (position+current.length()+1  == this.position) {
			eof = false;
		}
		if (position + current.length()+1 < this.position) {
			try {
				input.reset();
				input.skip(position);
				this.position = position;
				next();
				eof = false;
			} catch (IOException e) {
				e.printStackTrace();
				eof = true;
			}
		}
	}

	
	/* (non-Javadoc)
	 * @see lexer.ILexer#next()
	 */
	public void next () {
		current=new StringBuffer();
		int state = INIT_STATE;
		boolean loop=true;

		while (loop) {
			try {
				int car = input.read();
				eof = (car == -1);
				if (! eof) ++position;
				
				switch (state) {

				// Init state
				case INIT_STATE :
					if(! Character.isWhitespace(car)) {
						if(((char) car) == stringDelimiter) {
							// Beginning of a string token
							state = STRING_STATE;
						}
						else {
							current.append((char) car);
							state = TOKEN_STATE;

							// Start of a single-line comment ?
							if(current.toString().equals(eolComment)) {
								state = EOLCOMMENT_STATE;
							}
							// Start of a block comment ?
							else if(current.toString().equals(blockCommentStart)) {
								state = BLOCKCOMMENT_STATE;
							}
							// "One character" separator ?
							else {
								String sep = this.getSeparator(current.toString());
								if(sep != null) loop = false;
							}
						}
					}
					break;

				// Reading a token
				case TOKEN_STATE :
					if(! Character.isWhitespace(car)) {
						current.append((char) car);
						
						// Start of a single-line comment ?
						if(current.toString().endsWith(eolComment)) {
							// Reading has started with a token (token//eolComment)
							if(current.toString().length() > eolComment.length()) {
								current.setLength(current.length()-eolComment.length());
								position = position - eolComment.length();
								input.reset();
								input.skip(position);
								loop = false;
							}
							// Reading has started with an end-of-line comment (//eolComment)
							else {
								state = EOLCOMMENT_STATE;
							}
						}
						// Start of a block comment ?
						else if(current.toString().endsWith(blockCommentStart)) {
							// Reading has started with a token (token/*blockComment)
							if(current.toString().length() > blockCommentStart.length()) {
								current.setLength(current.length()-blockCommentStart.length());
								position = position - blockCommentStart.length();
								input.reset();
								input.skip(position);
								loop = false;
							}
							// Reading has started with a block comment (/*blockComment)
							else {
								state = BLOCKCOMMENT_STATE;
							}
						}
						// Separator ?
						else {
							String sep = this.getSeparator(current.toString());
							if(sep != null) {
								position = position - sep.length();
								input.reset();
								input.skip(position);
								current = new StringBuffer(current.substring(0, current.length()-sep.length()));
								loop = false;
							}
						}
					}
					else {
						loop = false;
					}
					break;

				// Reading a string
				case STRING_STATE :
					if(((char) car) == escapeCharacter) {
						state = ESCAPEDCHAR_STATE;
						
						// Escape character corresponds to string delimiter
						// => requires to inspect following character
						if(escapeCharacter == stringDelimiter) {
							int nextCar = input.read();
							if(Character.isWhitespace(nextCar)) {
								loop = false;
							}
							else if(getSeparator( String.valueOf((char) nextCar)) != null) {
								loop = false;
							}
							input.reset();
							input.skip(position);
						}
					}
					else if(((char) car) != stringDelimiter) {
						current.append((char) car);
					}
					else {
						// End of string reached
						loop = false;
					}
					break;
				
				// Reading an escaped character
				case ESCAPEDCHAR_STATE :
					current.append((char) car);
					state = STRING_STATE;
					break;

				// Reading an end-of-line comment
				case EOLCOMMENT_STATE :
					if(((char) car) == '\n') {
						current.setLength(0);
						state = INIT_STATE;
					}
					break;

				// Reading a block comment
				case BLOCKCOMMENT_STATE :
					current.append((char) car);
					if(current.toString().endsWith(blockCommentEnd)) {
						current.setLength(0);
						state = INIT_STATE;
					}
					break;
				}
			}
			catch (IOException e) {
				eof = true;
			}
			if (eof) loop = false;
		}
	}
	
	
	/* (non-Javadoc)
	 * @see fr.irisa.triskell.kermeta.textloader.lexer.ILexer#close()
	 */
	public void close() {
		try {
			this.input.close();
		}
		catch(IOException e) {
		}
	}

	
	/**
	 * @param s
	 * @return
	 */
	private String getSeparator(String s) {
		Iterator<Terminal> i = separators.iterator();
		while(i.hasNext()) {
			Terminal ter = i.next();
			if(ter.isCaseSensitive()) {
				if(s.endsWith(ter.getTerminal())) return ter.getTerminal();
			}
			else {
				if(s.toUpperCase().endsWith(ter.getTerminal().toUpperCase())) return ter.getTerminal();
			}
			//if(s.endsWith(ter.getTerminal())) return ter.getTerminal();
		}
		return null;
	}
	
	
	/**
	 * @param s
	 * @return
	 */
	public boolean isTerminal(String s) {
		Iterator<Terminal> i = terminals.iterator();
		while(i.hasNext()) {
			Terminal ter = i.next();
			if(ter.isCaseSensitive()) {
				if(s.equals(ter.getTerminal())) return true;
			}
			else {
				if(s.toUpperCase().equals(ter.getTerminal().toUpperCase())) return true;
			}
		}
		return false;
	}
}
