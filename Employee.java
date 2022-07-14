package com.main;

public class Employee {
	private int id;
	private String Name;
	private String Username;
	private String Password;
	private int Curr_Points;
	private int Total_Points;
	
	public Employee(){
		super();
	}
	public Employee(int id, String Name, String Username, String Password, int Curr_Points, int Total_Points){
		super();
		this.id = id;
		this.Name = Name;
		this.Username = Username;
		this.Password = Password;
		this.Curr_Points = Curr_Points;
		this.Total_Points = Total_Points;
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
	public String getUsername() {
		return Username;
	}
	public void setUsername(String Username) {
		this.Username = Username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public int getCurr_Points() {
		return Curr_Points;
	}
	public void setCurr_Points(int Curr_Points) {
		this.Curr_Points = Curr_Points;
	}
	public int getTotal_Points() {
		return Total_Points;
	}
	public void setTotal_Points(int Total_Points) {
		this.Total_Points = Total_Points;
	}
	
	
}
