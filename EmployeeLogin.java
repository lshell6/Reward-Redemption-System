package com.main;
import com.main.Employee;
import java.util.Scanner;

public class EmployeeLogin {
	
	public void ShowMenuAndProcess(){
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
					System.out.println("Enter username");
					String username = sc.next();
					// validate username
//					 boolean isValid = EmployeeUtility.validateEmployee(db.fetchEmployees(),username);
//					 if(!isValid) {
//						 System.out.println("Invalid Username, Try Again!");
//						 break;
//					 }
					System.out.println("Enter password");
					String password = sc.nextLine();
					// validate password
					break;
				case 2: 
					System.out.println("Enter username");
					username = sc.next();
					// call isValid to validate employee username
					if(true) { // if (!isValid)
						System.out.println("Invalid ID, Try Again!");
						break;
					}
					
					
					break;
				case 3: 
					System.out.println("Enter name");
					String name = sc.nextLine();
					System.out.println("Enter username");
					username = sc.next();
					// check if username is taken // else create new employee
					System.out.println("Enter password");
					password = sc.nextLine();
					break;
				default:
					break;
			}
				
		}
		
	}
}
