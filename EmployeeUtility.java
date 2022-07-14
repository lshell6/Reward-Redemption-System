package com.main;

import com.main.Employee;
import java.util.List;

public class EmployeeUtility {
	
	public static boolean validateEmployeeUsername(List<Employee> list, String Username) {
		boolean isPresent = false;
		 for(Employee e:list) {
			 if(e.getUsername().equals(Username)) {
				 isPresent = true;
				 break;
			 }		 
		 }
		return isPresent;
	}
	public static boolean validateManagerUsername(List<Manager> list, String Username) {
		boolean isPresent = false;
		 for(Manager e:list) {
			 if(e.getUsername().equals(Username)) {
				 isPresent = true;
				 break;
			 }		 
		 }
		return isPresent;
	}

	public static boolean validateEmployeeCredentials(List<Employee> list, String Username, String Password) {
		boolean isPresent = false;
		for(Employee e: list) {
			if(e.getUsername().equals(Username)) {
				if(e.getPassword().equals(Password)) {
					isPresent = true;
					break;
				}
			}
		}
		return isPresent;
	}
	
	public static boolean validateManagerCredentials(List<Manager> list, String Username, String Password) {
		boolean isPresent = false;
		for(Manager m: list) {
			if(m.getUsername().equals(Username)) {
				if(m.getPassword().equals(Password)) {
					isPresent = true;
					break;
				}
			}
		}
		return isPresent;
	}
}
