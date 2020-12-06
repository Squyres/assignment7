package com.meritamerica.assignment5;

import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Transaction {
	protected BankAccount sourceAccount;
	protected BankAccount targetAccount;
	protected double amount;
	protected String reason;
	protected Date transactionDate;
	protected boolean isProcessed;

	public BankAccount getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(BankAccount sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public BankAccount getTargetAccount() {
		return targetAccount;
	}

	public void setTargetAccount(BankAccount targetAccount) {
		this.targetAccount = targetAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public java.util.Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(java.util.Date date) {
		transactionDate = date;
	}

	public String writeToString() {
		String write = "";
		if (sourceAccount == targetAccount)
			write += "-1,";
		else
			write += sourceAccount.getAccountNumber() + ",";
		write += targetAccount.getAccountNumber() + "," + amount + "," + transactionDate;
		return write;
	}

	public static Transaction readFromString(String transactionDataString) throws ParseException { // buggy
		// String[] tran = transactionDataString.split(",");
		// SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
		// int source = Integer.parseInt(tran[0]);
		// int target = Integer.parseInt(tran[1]);
		// double amount = Double.parseDouble(tran[2]);
		// Date accountOpenedOn = date.parse(tran[3]);
		// boolean isDeposit = false;
		// if (amount >= 0) {
		// isDeposit = true;
		// }
		// if (isDeposit) {
		// TransferTransaction newTT = new
		// TransferTransaction(MeritBank.getBankAccount(target),
		// MeritBank.getBankAccount(source), amount);
		// newTT.setTransactionDate(accountOpenedOn);
		// return newTT;
		// } else if (!isDeposit) {
		// WithdrawTransaction newWT = new
		// WithdrawTransaction(MeritBank.getBankAccount(target), amount);
		// newWT.setTransactionDate(accountOpenedOn);
		// return newWT;
		// } else
		return null;
	}

	public abstract void process()
			throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException;

	public boolean isProcessedByFraudTeam() {
		return isProcessed;
	}

	public void setProcessedByFraudTeam(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}

	public String getRejectionReason() {
		return reason;
	}

	public void setRejectionReason(String reason) {
		this.reason = reason;
	}

}
