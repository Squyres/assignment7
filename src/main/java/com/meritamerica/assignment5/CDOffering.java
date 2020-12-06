
package com.meritamerica.assignment4;


public class CDOffering {
	private int term;
	private double interestRate;

	public CDOffering(int term, double interestRate) {
		this.term = term;
		this.interestRate = interestRate;
	}

	public int getTerm() {
		return term;
	}

	public double getInterestRate() {
		return interestRate;
	}
	
	static CDOffering readFromString(String cdOfferingDataString) {
		  String[] cd = cdOfferingDataString.split(",");
		  CDOffering newCD = new CDOffering(Integer.valueOf(cd[0]), Double.valueOf(cd[1]));
		  return newCD;
		  
	}
	
	String writeToString() {
		return term + "," + interestRate;
	}
}