/*
 * Created on 18 janv. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.kermeta.sintaks.lexer;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public class Lexer implements ILexer {
	
	private Reader input;
	private StringBuffer current;
	private long position;
	private boolean eof;
	private List<String> terminals;
	private List<String> separators;

	
	/**
	 * @param input
	 * @param res
	 */
	public Lexer(Reader input, List<String> terminals, List<String> separators) {
		this.input = input;
		this.separators = separators;
		this.terminals = terminals;
	}
	

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
		//return eof;
		return ( current==null || current.toString().charAt(0) == ((char) -1) );
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
		int state=1;
		boolean loop=true;
		while (loop) {
			try {
				int car = input.read();
				eof = (car == -1);
				if (! eof) ++position;
				
				switch (state) {
				case 1 :
					if(! Character.isWhitespace(car)) {
						if( ((char) car) == '\"' ) {
							state = 3;
						}
						else {
							current.append((char) car);
							state = 2;
							String sep = this.getSeparator(current.toString());
							if(sep != null) loop = false;  // "One character" separator
						}
					}
					break;
				case 2 :
					if(! Character.isWhitespace(car)) {
						current.append((char) car);

						String sep = this.getSeparator(current.toString());
						if(sep != null) {
							position = position - sep.length();
							input.reset();
							input.skip(position);
							current = new StringBuffer(current.substring(0, current.length()-sep.length()));
							loop = false;
						}
					}
					else {
						loop = false;
					}
					break;
				case 3 :
					if( ((char) car) != '\"' ) {
						current.append((char) car);
					}
					else {
						loop = false;
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
		Iterator<String> i = separators.iterator();
		while(i.hasNext()) {
			String ter = i.next();
			if(s.endsWith(ter)) return ter;
		}
		return null;
	}
	
	
	/**
	 * @param s
	 * @return
	 */
	public boolean isTerminal(String s) {
		Iterator<String> i = terminals.iterator();
		while(i.hasNext()) {
			String ter = i.next();
			if(s.equals(ter)) return true;
		}
		return false;
	}
}