package com.main;
import com.main.Manager;

import java.sql.SQLException;
import java.util.Scanner;

public class ManagerLogin {

	public void ShowMenuAndProcess() throws SQLException{
		DB db = new DB();
		Manager manager = new Manager(); 
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("*****Manager Login*****");
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
					 boolean isValid = EmployeeUtility.validateManagerCredentials(db.fetchManager(),username, password);
					 if(!isValid) {
					 System.out.println("Invalid Credentials, Try Again!");
					 	break;
					 }
					 
					System.out.println("Login Successful!");
					 // IMPLEMENT NEW MENU FOR MANAGERS
					while(true) {
						System.out.println("*****Manager Portal*****");
						System.out.println("1. Give Points to Employee");
						System.out.println("0. To Exit");
						System.out.println("Enter your input: ");
						input = sc.nextInt();
						if(input == 0) {
							System.out.println("Exiting..");
							break; 
						}
						switch(input) {
							case 1: 
								GivePts gp = new GivePts();
								gp.awardPoints();
								break;
							default:
								break;
						}
					}
					
						
				case 2: 
					System.out.println("***** Change Password *****");
					System.out.println("Enter username");
					username = sc.next();
					System.out.println("Enter current password");
					password = sc.nextLine();
					// call isValid to validate manager username
					isValid = EmployeeUtility.validateManagerCredentials(db.fetchManager(),username,password);
					if(!isValid) {
						System.out.println("Invalid Credentials, Try Again!");
					break;
					}
					// Prompt user to enter new password (maybe confirm the new password?)
					// after input update new password
					Manager man = db.fetchManager(username);
					System.out.println("Enter new password");
					String newPassword = sc.nextLine();
					System.out.println("Confirm new password");
					String newPasswordConfirm = sc.nextLine();
					if(newPassword.equals(newPasswordConfirm)) {
						manager.setPassword(newPassword);
						db.updateManagerPassword(manager);
					}
					else {
						System.out.println("Passwords do not match.");
					}
				case 3: 
					System.out.println("Enter name");
					String name = sc.next();
					System.out.println("Enter username");
					username = sc.next();
					isValid = EmployeeUtility.validateManagerUsername(db.fetchManager(),username);
					if(!isValid) { // if not valid, username does not exist
						System.out.println("Enter password");
						password = sc.nextLine();		
						// once user input is complete store the new account into the data base.
						Manager newMan = new Manager();
						newMan.setName(name);
						newMan.setUsername(username);
						newMan.setPassword(password);
						
						db.insertManager(newMan);
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
