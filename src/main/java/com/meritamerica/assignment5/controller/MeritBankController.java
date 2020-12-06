package com.meritamerica.assignment5.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment5.*;

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
	public AccountHolder getAccountHolderByID(@PathVariable int id) {
		AccountHolder actSearch = null;
		for (AccountHolder ach : accountHolders) {
			if (ach.getId() == id) {
				actSearch = ach;
			}
		}
		return actSearch;
	}
	@PostMapping("/AccountHolders/{id}/CheckingAccounts")
	public CheckingAccount addCheckingAccount(@PathVariable int id, @RequestBody @Valid CheckingAccount newAct) throws ExceedsCombinedBalanceLimitException {
		AccountHolder ach = getAccountHolderByID(id);
		ach.addCheckingAccount(newAct);
		return newAct;
	}
}
