package com.main;

import java.util.List;

public class Redeem {
	private int cost;
	private int curPts;
	private List<Item> cart;
	
	@Override
	public String toString() {
		return "Redeem [cost=" + cost + ", curPts=" + curPts + ", cart=" + cart + "]";
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getCurPts() {
		return curPts;
	}

	public void setCurPts(int curPts) {
		this.curPts = curPts;
	}

	public List<Item> getCart() {
		return cart;
	}

	public void setCart(List<Item> cart) {
		this.cart = cart;
	}

	public Redeem(int cost, int curPts, List<Item> cart) {
		super();
		this.cost = cost;
		this.curPts = curPts;
		this.cart = cart;
	}

	public Redeem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int Checkout(int cost, int curPts, List<Item> cart) {
		for (Item i : cart) {
			System.out.println(i);
		}
		System.out.println("Total: " + cost + "pts");
		int transaction = curPts - cost;
		return transaction;
	}
}
