package com.main;

import com.main.Employee;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeMenu {
	public void EmpMenu(String username) throws SQLException {

		DB db = new DB();

		while(true) {
			Employee emp = new Employee();
			Scanner sc = new Scanner(System.in);
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
			switch(input) {
			case 1:
				List<Item> items = db.fetchItems();
				for (Item i : items) {
					System.out.println(i);
				}
				System.out.println("Select an item to redeem: ");
				input = sc.nextInt();
				Item item = new Item();
				int id = item.getId();
				int curPts = emp.getCurrPts();
				int totPts = emp.getTotalPts();
				int cost = item.getPtValue();
				if (id != input) {
					System.out.println("Invalid selection, try again.");
					break;
				}
				if (curPts < cost) {
					System.out.println("Insufficient funds.");
					break;
				}
				List<Item> cart = new ArrayList<>();
				cart.add(item);
				System.out.println("Item added to cart. Checkout?(Y/N)");
				String inputC = sc.nextLine();
				if (inputC.equals("N") || inputC.equals("n")) {
					break;
				}
				Redeem transaction = new Redeem();
				totPts = transaction.Checkout(cost, curPts, cart);
				emp.setTotalPts(totPts);
				emp.setCurrPts(totPts);
				pts = totPts;
				System.out.println("Item redeemed.");
				break;
			case 2:
				pts = emp.getCurrPts();
				System.out.println("Current points: " + pts);
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		}
	}
}
