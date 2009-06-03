package org.kermeta.sintaks.subject;

import java.util.ArrayList;
import java.util.List;

public class Mark {
	private int position;
	private List<Ghost> ghosts;

	public Mark(int position, List<Ghost> ghosts) {
		super();
		this.position = position;
		this.ghosts = clone (ghosts);
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	private List<Ghost> clone (List<Ghost> ori) {
		return new ArrayList<Ghost> (ori);
	}

	public List<Ghost> getGhosts() {
		return ghosts;
	}

	public void setGhosts(List<Ghost> ghosts) {
		this.ghosts = clone (ghosts);
	}

}
