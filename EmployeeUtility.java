package com.main;

import com.main.Employee;
import java.util.List;

public class EmployeeUtility {

	public static boolean validateCredentials(List<Employee> list, String username, String password) {
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
}
