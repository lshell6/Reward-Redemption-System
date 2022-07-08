package com.g5;

public class GivePts {
	private int numOfPts;
	private int totPts;
	Manager m = new Manager();
	Employee e = new Employee();

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
		String mID = m.getId();
		String eID = e.getId();
		e.setCurrPts(totPts);
		e.setTotalPts(totPts);
	}
}
