package com.main;

public class Item {
	private String id;
	private String name;
	private int ptValue;
	
	Item(){
		super();
	}
	
	Item(String id, String name, int ptValue){
		super();
		this.id = id;
		this.name = name;
		this.ptValue = ptValue;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
