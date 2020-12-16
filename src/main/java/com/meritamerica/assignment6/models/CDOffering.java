
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

	public double getInterestRate() {
		return interestRate;
	}

	public int getTerm() {
		return term;
	}

	String writeToString() {
		return term + "," + interestRate;
	}
}