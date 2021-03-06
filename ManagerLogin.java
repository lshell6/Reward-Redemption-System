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
			System.out.println("0. Exit");
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
				System.out.println("Successfully logged out.");
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
					 boolean isValid = EmployeeUtility.validateManagerCredentials(db.fetchManagers(),Username, Password);
					 if(!isValid) {
					 System.out.println("Invalid Credentials, Try Again!");
					 	break;
					 }
					 manager = db.fetchManager(Username);
					System.out.println("Login Successful!");
					 // IMPLEMENT NEW MENU FOR MANAGERS
					while(true) {
						System.out.println("*****Manager Portal*****");
						System.out.println("Welcome " + manager.getName() + "!");
						System.out.println();
						System.out.println("1. Give Points to Employee");
						System.out.println("0. Logout");
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
					break;
						
				case 2: 
					System.out.println("***** Change Password *****");
					System.out.println("Enter Username");
					Username = sc.next();
					System.out.println("Enter Current Password");
					Password = sc.next();
					// call isValid to validate manager Username
					isValid = EmployeeUtility.validateManagerCredentials(db.fetchManagers(),Username,Password);
					if(!isValid) {
						System.out.println("Invalid Credentials, Try Again!");
					break;
					}
					// Prompt user to enter new Password (maybe confirm the new Password?)
					// after input update new Password
					Manager man = db.fetchManager(Username);
					System.out.println("Enter new Password");
					String newPassword = sc.next();
					System.out.println("Confirm new Password");
					String newPasswordConfirm = sc.next();
					if(newPassword.equals(newPasswordConfirm)) {
						man.setPassword(newPassword);
						db.updateManagerPassword(man);
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
					isValid = EmployeeUtility.validateManagerUsername(db.fetchManagers(),Username);
					if(!isValid) { // if not valid, Username does not exist
						System.out.println("Enter Password");
						Password = sc.next();		
						// once user input is complete store the new account into the data base.
						Manager newMan = new Manager();
						newMan.setName(Name);
						newMan.setUsername(Username);
						newMan.setPassword(Password);
						
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
