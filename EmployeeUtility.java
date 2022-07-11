package com.main;

import com.main.Employee;
import java.util.List;

public class EmployeeUtility {

	public static boolean validateUsername(List<Employee> list, String username) {
		boolean isPresent = false;
		for(Employee e: list) {
			if(e.getUsername() == username) {
				isPresent = true;
				break;
			}
		}
		return isPresent;
	}
	
	// this is wrong, Should we use map for this?
	public static boolean validatePassword(List<Employee> list, String password, String username) {
		boolean isPresent = false;
		for(Employee e: list) {
			if(e.getUsername() == username && e.getPassword() == password) {
				isPresent = true;
				break;
			}
		}
		return isPresent;
	}
}
