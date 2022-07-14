package com.main;

import java.util.List;


public class Redeem {
	
	public int Checkout(int cost, int curPts, List<Item> cart) {
		for (Item i : cart) {
			System.out.println(i);
		}
		System.out.println("Total: " + cost + "pts");	
		int buy = curPts - cost;
		return buy;
	}
}
