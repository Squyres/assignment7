package com.meritamerica.assignment5;

public class TransferTransaction extends Transaction {
	TransferTransaction(BankAccount sourceAccount, BankAccount targetAccount, double amount) {
		this.sourceAccount = sourceAccount;
		this.targetAccount = targetAccount;
		this.amount = amount;
	}

	@Override
	public void process()
			throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException {
		sourceAccount.withdraw(amount);
		targetAccount.deposit(amount);

	}
}
