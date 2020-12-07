package com.meritamerica.assignment5;
class AccountHolderIdNotFoundException extends RuntimeException {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  AccountHolderIdNotFoundException(Long id) {
    super("Could not find employee " + id);
  }
}
