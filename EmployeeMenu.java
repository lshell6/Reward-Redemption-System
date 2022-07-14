package com.main;

import com.main.Employee;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.main.Redeem;

public class EmployeeMenu {
	public void EmpMenu(String Username) throws SQLException {

		DB db = new DB();

		while(true) {
			Employee emp = new Employee();
			Scanner sc = new Scanner(System.in);
			System.out.println("*****Employee Menu (" + Username + ")*****");
			System.out.println("1. Redeem points");
			System.out.println("2. View Curr_ent points");
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
				int curPoints = emp.getCurr_Points();
				int totPoints = emp.getTotal_Points();
				int cost = item.getPtValue();
				int Points;
				if (id != input) {
					System.out.println("Invalid selection, try again.");
					break;
				}
				if (curPoints < cost) {
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
				totPoints = transaction.Checkout(cost, curPoints, cart);
				emp.setTotal_Points(totPoints);
				emp.setCurr_Points(totPoints);
				Points = totPoints;
				System.out.println("Item redeemed.");
				break;
			case 2:
				Points = emp.getCurr_Points();
				System.out.println("Curr_ent points: " + Points);
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		}
	}
}
