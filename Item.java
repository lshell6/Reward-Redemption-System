package com.main;

public class Item {
	private int id;
	private String Name;
	private int ptValue;
	
	Item(){
		super();
	}
	
	Item(int id){
		super();
		this.id=id;
	}
	
	Item(int id, String Name, int ptValue){
		super();
		this.id = id;
		this.Name = Name;
		this.ptValue = ptValue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public int getPtValue() {
		return ptValue;
	}

	public void setPtValue(int ptValue) {
		this.ptValue = ptValue;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", Name=" + Name + ", ptValue=" + ptValue + "]";
	}
}
