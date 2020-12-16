package com.meritamerica.assignment6.models;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountHolderNotFoundException extends Exception {

	public AccountHolderNotFoundException(int id) {
		super("Could not find employee " + id);
	}

	public AccountHolderNotFoundException() {
		super("Could not find employee");
	}
}