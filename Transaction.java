package com.main;

public class Transaction {
	private String id;
	private int numOfItems;
	private int totalPtValue;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNumOfItems() {
		return numOfItems;
	}
	public void setNumOfItems(int numOfItems) {
		this.numOfItems = numOfItems;
	}
	public int getTotalPtValue() {
		return totalPtValue;
	}
	public void setTotalPtValue(int totalPtValue) {
		this.totalPtValue = totalPtValue;
	}
	
}
