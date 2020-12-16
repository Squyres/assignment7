package com.meritamerica.assignment6.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.meritamerica.assignment6.exceptions.ExceedsFraudSuspicionLimitException;

@Entity
@Table(name = "CDAccount")
public class CDAccount extends BankAccount {

	CDOffering offering;
	@Min(value = 1)
	private int term;
	Date date;

	@ManyToOne
	@JoinColumn(name = "accountholder_id", nullable = false)
	private AccountHolder ah;

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

	public void addAccountHolder(AccountHolder ah) {
		this.ah = ah;
	}

	@Override
	public boolean deposit(double amount) throws ExceedsFraudSuspicionLimitException {
		throw new ExceedsFraudSuspicionLimitException();
	}

	public double futureValue() throws ExceedsFraudSuspicionLimitException {
		throw new ExceedsFraudSuspicionLimitException();
	}

	public Date getStartDate() {
		return date;
	}

	public int getTerm() {
		return this.term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	@Override
	public boolean withdraw(double amount) throws ExceedsFraudSuspicionLimitException {
		throw new ExceedsFraudSuspicionLimitException();
	}

}
