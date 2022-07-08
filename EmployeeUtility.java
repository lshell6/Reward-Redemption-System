package com.main;


public class EmployeeUtility {
	public static boolean validateId(List<Employee> list, int id) {
		boolean isPresent = false;
		 for(Employee e:list) {
			 if(e.getId() == id) {
				 isPresent = true;
				 break;
			 }		 
		 }
		return isPresent;
}
