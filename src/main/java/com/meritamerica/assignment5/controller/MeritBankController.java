package com.meritamerica.assignment5.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment5.*;

@RestController
public class MeritBankController {
	
	List<AccountHolder> accountHolders = new ArrayList<AccountHolder>();

	@PostMapping(value = "/AccountHolders")
	public AccountHolder addAccountHolder(@RequestBody @Validated AccountHolder newAct) {
		accountHolders.add(newAct);
		return newAct;

	}

}