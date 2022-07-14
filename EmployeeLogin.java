package com.main;
import com.main.Employee;
import com.main.EmployeeUtility;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeLogin {
	
	public void ShowMenuAndProcess() throws SQLException{
		DB db = new DB();
		Employee employee = new Employee(); 
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("*****Employee Login*****");
			System.out.println("1. Login");
			System.out.println("2. Change Password");
			System.out.println("3. Register");
			System.out.println("0. To Exit");
			System.out.println("Enter your input: ");
			int input = sc.nextInt();
			if(input == 0) {
				System.out.println("Exiting.. Bye!!");
				break; 
			}
			
			switch(input) {
				case 1:
					System.out.println("***** Login *****");
					System.out.println("Enter username");
					String username = sc.next();
					System.out.println("Enter password");
					String password = sc.nextLine();
					// validate username
					 boolean isValid = EmployeeUtility.validateEmployeeCredentials(db.fetchEmployees(),username, password);
					 if(!isValid) {
						 System.out.println("Invalid Credentials, Try Again!");
					 break;
					 }
					 
					 System.out.println("Login Successful!");
					 EmployeeMenu empMenu = new EmployeeMenu();
					 empMenu.EmpMenu(username);
				case 2: 
					System.out.println("***** Change Password *****");
					System.out.println("Enter username");
					username = sc.next();
					System.out.println("Enter current password");
					password = sc.nextLine();
					// call isValid to validate employee username
					isValid = EmployeeUtility.validateEmployeeCredentials(db.fetchEmployees(),username,password);
					if(!isValid) {
						System.out.println("Invalid Credentials, Try Again!");
					break;
					}
					// Prompt user to enter new password (maybe confirm the new password?)
					// after input update new password
					Employee emp = db.fetchEmployee(username);
					System.out.println("Enter new password");
					String newPassword = sc.nextLine();
					System.out.println("Confirm new password");
					String newPasswordConfirm = sc.nextLine();
					if(newPassword.equals(newPasswordConfirm)) {
						employee.setPassword(newPassword);
						db.updateEmployeePassword(employee);
						System.out.println("Password has been updated!");
					}
					else {
						System.out.println("Passwords do not match.");
					}
				case 3: 
					System.out.println("Enter name");
					String name = sc.next();
					System.out.println("Enter username");
					username = sc.next();
					// check if username is taken // else create new employee
					System.out.println("Enter password");
					password = sc.nextLine();		
					// once user input is complete store the new account into the data base.
					Employee newEmp = new Employee();
					newEmp.setName(name);
					newEmp.setUsername(username);
					newEmp.setPassword(password);
					newEmp.setCurrPts(0);
					newEmp.setTotalPts(0);
					
					db.insertEmployee(newEmp);
					
					break;
				default:
					break;
			}
				
		}
		
	}
}
