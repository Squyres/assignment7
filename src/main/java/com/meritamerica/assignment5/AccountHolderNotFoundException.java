package com.meritamerica.assignment5;
class AccountHolderNotFoundException extends RuntimeException {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  AccountHolderNotFoundException(Long id) {
    super("Could not find employee " + id);
  }
}
