package com.dineshwork.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trade {

	@Id
	private int id;
	private String type;
	private User user;
	private String symbol;
	private int shares;
	private float price;
	
	public Trade() {
		
	}
	
	public Trade(int id, String type, User user, String symbol, int shares, float price) {
		super();
		this.id = id;
		this.type = type;
		this.user = user;
		this.symbol = symbol;
		this.shares = shares;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
	
}
