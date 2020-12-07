package com.meritamerica.assignment5;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AccountHolderIdNotFoundException extends Exception {
	public AccountHolderIdNotFoundException(int id) {
		super("Could not find employee " + id);
	}
}
