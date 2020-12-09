package com.meritamerica.assignment5;

import java.text.*;
import java.util.Date;

import javax.validation.constraints.Min;

public class CDAccount extends BankAccount {

	CDOffering offering;
	@Min(value = 1)
	private int term;
	Date date;

	public CDAccount() {
		this.balance = 0;
	}
	
	public CDAccount(CDOffering offering, double openBalance) {
		super(openBalance, offering.getInterestRate());
		this.offering = offering;
		this.term = offering.getTerm();
	}

	public CDAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn, int term) {
		super(accountNumber, balance, interestRate, accountOpenedOn);
		this.term = term;
	}

	public int getTerm() {
		return this.term;
	}
	
	public void setTerm(int term) {
		this.term = term;
	}

	public Date getStartDate() {
		return date;
	}

	public double futureValue() throws ExceedsFraudSuspicionLimitException {
		throw new ExceedsFraudSuspicionLimitException();
	}

	@Override
	public boolean withdraw(double amount) throws ExceedsFraudSuspicionLimitException {
		throw new ExceedsFraudSuspicionLimitException();
	}

	@Override
	public boolean deposit(double amount) throws ExceedsFraudSuspicionLimitException {
		throw new ExceedsFraudSuspicionLimitException();
	}

	public static CDAccount readFromString(String accountData) throws ParseException, NumberFormatException {
		String[] holding = accountData.split(",");
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		long accountNumber = Long.parseLong(holding[0]);
		double balance = Double.parseDouble(holding[1]);
		double interestRate = Double.parseDouble(holding[2]);
		Date accountOpenedOn = date.parse(holding[3]);
		int term = Integer.parseInt(holding[4]);
		CDAccount newCDAccount = new CDAccount(accountNumber, balance, interestRate, accountOpenedOn, term);
		return newCDAccount;
	}

	public String writeToString() {
		StringBuilder override = new StringBuilder();
		override.append(writeToString()).append(",");
		override.append(term);
		return override.toString();
	}

}