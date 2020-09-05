package com.parteek.thoughtworks.entity;

public class Cell {

	private int index;
	private char type;
	private Player owner;

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
