package com.meritamerica.assignment6.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment6.exceptions.AccountHolderIdNotFoundException;
import com.meritamerica.assignment6.exceptions.AccountHolderNotFoundException;
import com.meritamerica.assignment6.exceptions.ExceedsCombinedBalanceLimitException;
import com.meritamerica.assignment6.models.*;


@RestController
public class MeritBankController {

	List<AccountHolder> accountHolders = new ArrayList<AccountHolder>();

	@PostMapping(value = "/AccountHolders")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addAccountHolder(@RequestBody @Valid AccountHolder newAct) {
		accountHolders.add(newAct);
		return newAct;
	}

	@GetMapping("/AccountHolders")
	public List<AccountHolder> getAccountHolders() {
		return accountHolders;
	}

	@GetMapping("/AccountHolders/{id}")
	public AccountHolder getAccountHolderByID(@PathVariable int id) throws AccountHolderIdNotFoundException {
		AccountHolder actSearch = null;
		for (AccountHolder ach : accountHolders) {
			if (ach.getId() == id) {
				actSearch = ach;
			}
		}
		if (actSearch == null) {
			throw new AccountHolderIdNotFoundException(id);
		}
		return actSearch;
	}

	@PostMapping("/AccountHolders/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount addCheckingAccount(@PathVariable int id, @RequestBody @Valid CheckingAccount newAct)
			throws ExceedsCombinedBalanceLimitException, AccountHolderIdNotFoundException,
			AccountHolderNotFoundException {
		AccountHolder act = getAccountHolderByID(id);
		if (newAct.getBalance() + act.getCombinedBalance() > 250000) {
			throw new ExceedsCombinedBalanceLimitException();
		}
		act.addCheckingAccount(newAct);
		newAct.addAccountHolder(act);
		return newAct;
	}

	@GetMapping("/AccountHolders/{id}/CheckingAccounts")
	public List<CheckingAccount> getCheckingAccountsByID(@PathVariable int id) throws AccountHolderIdNotFoundException {
		AccountHolder act = getAccountHolderByID(id);
		if (act == null) {
			throw new AccountHolderIdNotFoundException(id);
		}
		return Arrays.asList(act.getCheckingAccounts());
	}

	@PostMapping("/AccountHolders/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public SavingsAccount addSavingsAccount(@PathVariable int id, @RequestBody @Valid SavingsAccount newAct)
			throws ExceedsCombinedBalanceLimitException, AccountHolderIdNotFoundException {
		AccountHolder act = getAccountHolderByID(id);
		if (newAct.getBalance() + act.getCombinedBalance() > 250000) {
			throw new ExceedsCombinedBalanceLimitException();
		}
		act.addSavingsAccount(newAct);
		newAct.addAccountHolder(act);
		return newAct;
	}

	@GetMapping("/AccountHolders/{id}/SavingsAccounts")
	public List<SavingsAccount> getSavingsAccountsByID(@PathVariable int id) throws AccountHolderIdNotFoundException {
		AccountHolder act = getAccountHolderByID(id);
		if (act == null) {
			throw new AccountHolderIdNotFoundException(id);
		}
		return Arrays.asList(act.getSavingsAccounts());
	}

	@PostMapping("/AccountHolders/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount addCDAccount(@PathVariable int id, @RequestBody @Valid CDAccount newAct)
			throws ExceedsCombinedBalanceLimitException, AccountHolderIdNotFoundException {
		AccountHolder act = getAccountHolderByID(id);
		act.addCDAccount(newAct);
		newAct.addAccountHolder(act);
		return newAct;
	}

	@GetMapping("/AccountHolders/{id}/CDAccounts")
	public List<CDAccount> getCDAccountsByID(@PathVariable int id) throws AccountHolderIdNotFoundException {
		AccountHolder act = getAccountHolderByID(id);
		return Arrays.asList(act.getCDAccounts());
	}

	List<CDOffering> cdOfferings = new ArrayList<CDOffering>();

	@PostMapping(value = "/CDOfferings")
	@ResponseStatus(HttpStatus.CREATED)
	public CDOffering addCDOffering(@RequestBody @Valid CDOffering newOffer) {
		cdOfferings.add(newOffer);
		return newOffer;

	}

	@GetMapping("/CDOfferings")
	List<CDOffering> getCDOfferings() {
		return cdOfferings;
	}

}
