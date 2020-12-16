package com.meritamerica.assignment6.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CDAccount")
public class SavingsAccount extends BankAccount {

	public static final double INTEREST_RATE = 0.01;

	@ManyToOne
	@JoinColumn(name = "accountholder_id", nullable = false)
	private AccountHolder ah;

	public SavingsAccount() {
		this.balance = 0;
		this.interestRate = INTEREST_RATE;
	}

	public SavingsAccount(double openBalance, double interestRate) {
		super(openBalance, interestRate);
	}

	public SavingsAccount(long accountNumber, double openBalance, double interestRate, Date accountOpenedOn) {
		super(accountNumber, openBalance, interestRate, accountOpenedOn);
	}

	public void addAccountHolder(AccountHolder ah) {
		this.ah = ah;
	}

	@Override
	public String toString() {
		return "Savings Account Balance: $" + balance + "\n" + "Savings Account Interest Rate: " + INTEREST_RATE + "\n"
				+ "Savings Account Balance in 3 years: $" + futureValue(3);

	}
}
