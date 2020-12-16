package com.meritamerica.assignment6.models;

public class DepositTransaction extends Transaction {
	
	DepositTransaction(BankAccount targetAccount, double amount) {
		
	}

	@Override
	public void process()
			throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException {
		// TODO Auto-generated method stub
		
	}

}
