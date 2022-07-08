package com.main.model;

public class Employee {
	private String id;
	private String name;
	private String username;
	private String password;
	private int currPts;
	private int totalPts;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCurrPts() {
		return currPts;
	}
	public void setCurrPts(int currPts) {
		this.currPts = currPts;
	}
	public int getTotalPts() {
		return totalPts;
	}
	public void setTotalPts(int totalPts) {
		this.totalPts = totalPts;
	}
	
	
}
