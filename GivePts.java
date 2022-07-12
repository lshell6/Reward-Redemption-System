package com.main;

import java.sql.SQLException;
import java.util.Scanner;

public class GivePts {
	private int numOfPts;
	private int totPts;
	Manager m = new Manager();
	Employee e = new Employee();
	
	DB db = new DB();
	Scanner sc = new Scanner(System.in);

	public int getTotPts() {
		return totPts;
	}

	public void setTotPts(int totPts) {
		this.totPts = totPts;
	}

	public int getNumOfPts() {
		return numOfPts;
	}

	public void setNumOfPts(int numOfPts) {
		this.numOfPts = numOfPts;
	}
		
		
	public int calcPts(int earnedPts) {
			numOfPts = e.getCurrPts();
			totPts = numOfPts + earnedPts;
			return totPts;
		}
		
	public GivePts() {
		int mID = m.getId();
		int eID = e.getId();
		e.setCurrPts(totPts);
		e.setTotalPts(totPts);
	}
	
	
	
	
	// -------- kyung's code --------
	public void awardPoints() {
		while(true) { // ask manager for username of employee and validate username
			System.out.println("Enter the employee's username: ");
			String username = sc.next();
			boolean isValid = false;
			try {
				isValid = EmployeeUtility.validateEmployeeUsername(db.fetchEmployees(),username);
			} catch (SQLException e) {			
				e.printStackTrace();
			}
			 if(!isValid) {
				 System.out.println("Invalid Credentials, Try Again!");
				 break;
			 }
				System.out.println("Enter the amount of points you would like to give: ");
				int points = sc.nextInt();
				e = db.fetchEmployee(username);
				int newCurrPts = e.getCurrPts() + points;
				int newTotPts = e.getTotalPts() + points;
				e.setCurrPts(newCurrPts);
				e.setTotalPts(newTotPts);
				
				try {
					db.updateEmployeeCurrentPoints(e);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					db.updateEmployeeTotalPoints(e);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
		}

		
		
		
		
	}
	
	
	
}
