package com.parteek.thoughtworks.entity;

import java.util.ArrayList;

import com.parteek.thoughtworks.constant.GameConstants;

public class Player {

	private int index;
	private double money;
	private int postion;
	private ArrayList<Cell> hotelOwned;
	
	public Player(int index) {
		this.index = index;
		this.postion = -1;
		this.money = GameConstants.INITIAL_MONEY;
		this.hotelOwned = new ArrayList<>();
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getPostion() {
		return postion;
	}

	public void setPostion(int postion) {
		this.postion = postion;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public ArrayList<Cell> getHotelOwned() {
		return hotelOwned;
	}

	public void setHotelOwned(ArrayList<Cell> hotelOwned) {
		this.hotelOwned = hotelOwned;
	}

	public void addHotel(Cell hotelOwned) {
		this.hotelOwned.add(hotelOwned);

	}

	public void addMoney(double money) {
		setMoney(getMoney() + money); 
		
	}
	
	public Double getWorth() {
		return this.getMoney() + (this.getHotelOwned().size() * GameConstants.HOTEL_WORTH);

	}
}
