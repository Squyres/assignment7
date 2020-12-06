package com.meritamerica.assignment4;

import java.util.ArrayList;

public class FraudQueue {
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	FraudQueue() {
		
	}
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
	public Transaction getTransaction() {
		return transactions.get(transactions.size() - 1);
	}


}