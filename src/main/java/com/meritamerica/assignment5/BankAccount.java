package com.meritamerica.assignment5;

import java.text.*;
import java.util.*;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

public abstract class BankAccount {
	@Min(value = 0)
	double balance;
	@DecimalMin(value = "0.0", inclusive = false, message = "Interest rate must be > 0")
	@DecimalMax(value = "1.0", inclusive = false, message = "Interest rate must be < 1")
	double interestRate;
	Date accountOpenedOn;
	long accountNumber;

	public BankAccount() {
		this.balance = 0;
		this.interestRate = 0;
	}

	public BankAccount(double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = new Date();
		this.accountNumber = MeritBank.getNextAccountNumber();
	}

	BankAccount(double balance, double interestRate, Date accountOpenedOn) {
		this.balance = balance;
		this.accountNumber = MeritBank.getNextAccountNumber();
		this.interestRate = interestRate;
		this.accountOpenedOn = accountOpenedOn;
	}

	public BankAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountNumber = accountNumber;
		this.accountOpenedOn = accountOpenedOn;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public java.util.Date getOpenedOn() {
		return accountOpenedOn;
	}

	public boolean withdraw(double amount) throws ExceedsFraudSuspicionLimitException {
		if (amount <= balance && amount > 0) {
			this.balance -= amount;
			System.out.println("Withdrawn amount: $" + amount);
			System.out.println("Remaining balance: $" + balance);
			return true;
		}
		return false;
	}

	public boolean deposit(double amount) throws ExceedsFraudSuspicionLimitException {
		if (amount <= 0) {
			System.out.println("Please deposit sufficient amount");
			return false;
		} else {
			balance += amount;
			System.out.println("Transation Complete");
			return true;
		}
	}

	public double futureValue(int years) {
		double futureVal = this.balance * Math.pow(1 + getInterestRate(), years);
		return futureVal;
	}

	public String writeToString() {
		StringBuilder accountData = new StringBuilder();
		accountData.append(accountNumber).append(",");
		accountData.append(accountOpenedOn).append(",");
		accountData.append(balance).append(",");
		accountData.append(interestRate);
		return accountData.toString();
	}

	public static BankAccount readFromString(String accountData) throws ParseException, NumberFormatException {
		try {
			String[] holding = accountData.split(",");
			SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
			Long accountNumber = Long.parseLong(holding[0]);
			double balance = Double.parseDouble(holding[1]);
			double interestRate = Double.parseDouble(holding[2]);
			Date accountOpenedOn = date.parse(holding[3]);
			if (interestRate == 0.01) {
				return new SavingsAccount(accountNumber, balance, interestRate, accountOpenedOn);
			} else
				return new CheckingAccount(accountNumber, balance, interestRate, accountOpenedOn);

		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		}

	}

	public void addTransaction(Transaction transaction) {

	}

	public List<Transaction> getTransactions() {
		List<Transaction> newL = new ArrayList<Transaction>();
		return newL;
	}

}
