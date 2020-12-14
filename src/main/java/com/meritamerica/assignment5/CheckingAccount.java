package com.meritamerica.assignment5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CheckingAccount")
public class CheckingAccount extends BankAccount {

	public static final double INTEREST_RATE = 0.0001;
	@ManyToOne
	@JoinColumn(name = "accountholder_id", nullable = false)
	private AccountHolder ah;

	public CheckingAccount() {
		this.balance = 0;
		this.interestRate = INTEREST_RATE;
	}

	public CheckingAccount(double openBalance, double interestRate) {
		super(openBalance, interestRate);
	}

	public CheckingAccount(long accountNumber, double openBalance, double interestRate, Date accountOpenedOn) {
		super(accountNumber, openBalance, interestRate, accountOpenedOn);
	}

	public boolean withdraw(double amount) {
		if (amount <= super.getBalance() && amount > 0) {
			this.balance = balance - amount;
			System.out.println("Withdrawn amount: " + amount);
			System.out.println("Remaining balance: " + balance);
			return true;
		}
		return false;
	}

	public void addAccountHolder(AccountHolder ah) {
		this.ah = ah;
	}

	public boolean deposit(double amount) {
		if (amount > 0) {
			this.balance = balance + amount;
			System.out.println("Deposited amount: " + amount);
			System.out.println("Total balance: " + balance);
			return true;
		}
		return false;
	}

	public String toString() {
		return "Checking Account Balance: $" + getBalance() + "\n" + "Checking Account Interest Rate: "
				+ getInterestRate() + "\n" + "Checking Account Balance in 3 years: $" + futureValue(3);

	}

	public static CheckingAccount readFromString(String accountData) throws ParseException {

		String[] holding = accountData.split(",");
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		long accountNumber = Long.parseLong(holding[0]);
		double balance = Double.parseDouble(holding[1]);
		double interestRate = Double.parseDouble(holding[2]);
		Date accountOpenedOn = date.parse(holding[3]);
		CheckingAccount newCheckingAccount = new CheckingAccount(accountNumber, balance, interestRate, accountOpenedOn);
		return newCheckingAccount;
	}
}
