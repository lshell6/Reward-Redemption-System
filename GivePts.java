package com.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GivePts {
	private int numOfPoints;
	private int totPoints;
	Manager m = new Manager();
	Employee e = new Employee();
	
	DB db = new DB();
	Scanner sc = new Scanner(System.in);

	public int getTotPoints() {
		return totPoints;
	}

	public void setTotPoints(int totPoints) {
		this.totPoints = totPoints;
	}

	public int getNumOfPoints() {
		return numOfPoints;
	}

	public void setNumOfPoints(int numOfPoints) {
		this.numOfPoints = numOfPoints;
	}
		
		
	public int calcPoints(int earnedPoints) {
			numOfPoints = e.getCurr_Points();
			totPoints = numOfPoints + earnedPoints;
			return totPoints;
		}
		
	public GivePts() {
		int mID = m.getId();
		int eID = e.getId();
		e.setCurr_Points(totPoints);
		e.setTotal_Points(totPoints);
	}
	
	
	
	
	// -------- kyung's code --------
	public void awardPoints() throws SQLException {
		while(true) { // ask manager for Username of employee and validate Username
			
			//show a list of employees
			List<Employee> emp = db.fetchEmployees();
			for (Employee e : emp) {
				System.out.println(e);
			}
			
			System.out.println("Enter the employee's Username: ");
			String Username = sc.next();
			boolean isValid = false;
			try {
				isValid = EmployeeUtility.validateEmployeeUsername(db.fetchEmployees(),Username);
			} catch (SQLException e) {			
				e.printStackTrace();
			}
			 if(!isValid) {
				 System.out.println("Invalid Credentials, Try Again!");
				 break;
			 }
				System.out.println("Enter the amount of points you would like to give: ");
				int points = sc.nextInt();
				e = db.fetchEmployee(Username);
				int newCurr_Points = e.getCurr_Points() + points;
				int newTotPoints = e.getTotal_Points() + points;
				e.setCurr_Points(newCurr_Points);
				e.setTotal_Points(newTotPoints);
				
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
				System.out.println("Successfully gave employee " + e.getUsername() 
									+ " " + points + " points!");
				break;
		}

		
		
		
		
	}
	
	
	
}
