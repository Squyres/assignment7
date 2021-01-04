package com.meritamerica.assignment7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment7.models.AccountHolder;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer> {
	AccountHolder findById(int id);
	AccountHolder findByFirstName(String fName);
}
