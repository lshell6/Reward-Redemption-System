package com.main;

import com.main.Employee;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeMenu {
	public void EmpMenu(String username) throws SQLException {

		DB db = new DB();

		while (true) {
			Employee e = new Employee();
			e = db.fetchEmployee(username);
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
					System.out.println("Select an item's id to redeem item: ");
					input = sc.nextInt();
					int id = input;
					Item item = db.selectItem(id);
					int curPts = e.getCurr_Points();
					int cost = item.getPtValue();
					int count = 0;
					if (id < 1 || id > 5) {
						System.out.println("Invalid selection, try again.");
						break;
					} else if (curPts < cost) {
						System.out.println("Insufficient funds.");
						break;
					}
					List<Item> cart = new ArrayList<>();
					cart.add(count, item);
					System.out.println("Item added to cart. Add another item?(Y/N)");
					String inputC = sc.next();
					while (inputC.equalsIgnoreCase("y")) {
						count++;
						System.out.println("Please select another item");
						for (Item i : items) {
							System.out.println(i);
						}
						input = sc.nextInt();
						id = input;
						item = db.selectItem(id);
						curPts = e.getCurr_Points();
						cost = cost + item.getPtValue();
						if (id < 1 || id > 5) {
							System.out.println("Invalid selection, try again.");
							break;
						} else if (curPts < cost) {
							System.out.println("Insufficient funds. Emptying cart");
							cart = new ArrayList<>();
							count = 0;
							break;
						}else {
							cart.add(count,item);
							System.out.println("Item added to cart. Add another item?(Y/N)");
						}
						inputC = sc.next();
					}
					if(count>0) {
						Redeem redeem = new Redeem();
						curPts = redeem.Checkout(cost, e.getCurr_Points(), cart);
						e.setCurr_Points(curPts);
						pts = curPts;
						db.updateEmployeeCurrentPoints(e);
						db.updateEmployeeTotalPoints(e);
					}
					System.out.println(count + " Item(s) redeemed.");
					break;
				}
			case 2:
				pts = e.getCurr_Points();
				System.out.println("Current points: " + e.getCurr_Points());
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		}
	}
}