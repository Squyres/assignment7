package com.meritamerica.assignment5;

public class WithdrawTransaction extends Transaction {

	WithdrawTransaction(BankAccount targetAccount, double amount) {
		this.targetAccount = targetAccount;
		this.amount = amount;
		this.sourceAccount = targetAccount;
	}

	@Override
	public void process()
			throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException {
		targetAccount.withdraw(amount);
	}
}