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
			if(input > 3) {
				while(input>3 && input!=0) {
					System.out.println("That is not an option please try again");
					System.out.println("Enter your input: ");
					input = sc.nextInt();
				}
			}
			else if(input == 0) {
				System.out.println("Exiting.. Bye!!");
				break; 
			}
			
			switch(input) {
				case 1:
					System.out.println("***** Login *****");
					System.out.println("Enter Username");
					String Username = sc.next();
					System.out.println("Enter Password");
					String Password = sc.next();
					// validate Username
					 boolean isValid = EmployeeUtility.validateEmployeeCredentials(db.fetchEmployees(),Username, Password);
					 if(!isValid) {
						 System.out.println("Invalid Credentials, Try Again!");
					 break;
					 }
					 
					 System.out.println("Login Successful!");
					 EmployeeMenu empMenu = new EmployeeMenu();
					 empMenu.EmpMenu(Username);
					 break;
				case 2: 
					System.out.println("***** Change Password *****");
					System.out.println("Enter Username");
					Username = sc.next();
					System.out.println("Enter Current Password");
					Password = sc.next();
					// call isValid to validate employee Username
					isValid = EmployeeUtility.validateEmployeeCredentials(db.fetchEmployees(),Username,Password);
					if(!isValid) {
						System.out.println("Invalid Credentials, Try Again!");
					break;
					}
					// Prompt user to enter new Password (maybe confirm the new Password?)
					// after input update new Password
					Employee emp = db.fetchEmployee(Username);
					System.out.println("Enter new Password");
					String newPassword = sc.next();
					System.out.println("Confirm new Password");
					String newPasswordConfirm = sc.next();
					if(newPassword.equals(newPasswordConfirm)) {
						emp.setPassword(newPassword);
						db.updateEmployeePassword(emp);
					}
					else {
						System.out.println("Passwords do not match.");
					}
					break;
				case 3: 
					System.out.println("Enter Name");
					String Name = sc.next();
					System.out.println("Enter Username");
					Username = sc.next();
					isValid = EmployeeUtility.validateEmployeeUsername(db.fetchEmployees(),Username);
					if(!isValid) { // if not valid, Username does not exist
						System.out.println("Enter Password");
						Password = sc.next();		
						// once user input is complete store the new account into the data base.
						Employee newEmp = new Employee();
						newEmp.setName(Name);
						newEmp.setUsername(Username);
						newEmp.setPassword(Password);
						newEmp.setCurr_Points(0);
						newEmp.setTotal_Points(0);
						
						db.insertEmployee(newEmp);
					}
					else {
						System.out.println("Username is taken, try again.");
					}
					
					break;
				default:
					break;
			}
				
		}
		
	}
}
