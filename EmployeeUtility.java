package com.main;

import com.main.Employee;
import java.util.List;

public class EmployeeUtility {
	
	public static boolean validateEmployeeUsername(List<Employee> list, String username) {
		boolean isPresent = false;
		 for(Employee e:list) {
			 if(e.getUsername() == username) {
				 isPresent = true;
				 break;
			 }		 
		 }
		return isPresent;
	}

	public static boolean validateEmployeeCredentials(List<Employee> list, String username, String password) {
		boolean isPresent = false;
		for(Employee e: list) {
			if(e.getUsername() == username) {
				if(e.getPassword() == password) {
					isPresent = true;
					break;
				}
			}
		}
		return isPresent;
	}
	
	public static boolean validateManagerCredentials(List<Manager> list, String username, String password) {
		boolean isPresent = false;
		for(Manager m: list) {
			if(m.getUsername() == username) {
				if(m.getPassword() == password) {
					isPresent = true;
					break;
				}
			}
		}
		return isPresent;
	}
}
