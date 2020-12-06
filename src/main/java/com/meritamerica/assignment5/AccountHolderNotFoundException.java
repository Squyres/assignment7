package com.meritamerica.assignment5;
class AccountHolderNotFoundException extends RuntimeException {

  AccountHolderNotFoundException(Long id) {
    super("Could not find employee " + id);
  }
}
