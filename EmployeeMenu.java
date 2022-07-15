package com.main;

import com.main.Employee;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmployeeMenu {
	public void EmpMenu(String username) throws SQLException {

		DB db = new DB();

		while (true) {
			Employee emp = new Employee();
			Scanner sc = new Scanner(System.in);
			int pts;
			System.out.println("*****Employee Menu (" + username + ")*****");
			System.out.println("1. Redeem points");
			System.out.println("2. View current points");
			System.out.println("0. Logout");
			System.out.println("Enter your input: ");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Successfully logged out.");
				break;
			}
			switch (input) {
			case 1:
				while (true) {
					List<Item> items = db.fetchItems();
					for (Item i : items) {
						System.out.println(i);
					}
					System.out.println("Select an item to redeem: ");
					input = sc.nextInt();
					Item item = new Item();
					int id = item.getId();
					int curPts = emp.getCurr_Points();
					int cost = item.getPtValue();
					if (id != input) {
						System.out.println("Invalid selection, try again.");
						break;
					} else if (curPts < cost) {
						System.out.println("Insufficient funds.");
						break;
					}
					List<Item> cart = db.selectItems();
					System.out.println("Item added to cart. Add another item?(Y/N)");
					String inputC = sc.next();
					if (inputC.equals("Y") || inputC.equals("y")) {
						break;
					}
					Redeem redeem = new Redeem();
					curPts = redeem.Checkout(cost, emp.getCurr_Points(), cart);
					emp.setCurr_Points(curPts);
					pts = curPts;
					System.out.println("Item redeemed.");
					break;
				}
			case 2:
				pts = emp.getCurr_Points();
				System.out.println("Current points: " + pts);
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		}
	}
}