package com.main;

public class Item {
	private int id;
	private String name;
	private int ptValue;
	
	Item(){
		super();
	}
	
	Item(int id, String name, int ptValue){
		super();
		this.id = id;
		this.name = name;
		this.ptValue = ptValue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPtValue() {
		return ptValue;
	}

	public void setPtValue(int ptValue) {
		this.ptValue = ptValue;
	}
}
