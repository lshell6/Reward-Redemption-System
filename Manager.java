package com.main;

public class Manager {
	private int id;
	private String Name;
	private String Username;
	private String Password;
	
	public Manager(){
		super();
	}
	public Manager(int id, String Name, String Username, String Password) {
		super();
		this.id = id;
		this.Name = Name;
		this.Username = Username;
		this.Password = Password;
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
	
	
}
