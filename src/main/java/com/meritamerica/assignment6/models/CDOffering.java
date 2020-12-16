
package com.meritamerica.assignment6.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CDOffering {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
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