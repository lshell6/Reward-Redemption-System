package com.main;

import com.main.EmployeeLogin;

import java.sql.SQLException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("***** Rewards System *****");
			System.out.println("1. Employee Login");
			System.out.println("2. Manager Login");
			System.out.println("0. Exit");
			System.out.println("Enter your input: ");
			int input = sc.nextInt();
			if(input > 2) {
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
				case 1: // employee login
					EmployeeLogin emp = new EmployeeLogin();
				try {
					emp.ShowMenuAndProcess();
				} catch (SQLException e) {
					e.printStackTrace();
				}
					break;
				case 2: // manager login
					ManagerLogin man = new ManagerLogin();
					try {
						man.ShowMenuAndProcess();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				default:
					break;
			}
		}
	}

}

