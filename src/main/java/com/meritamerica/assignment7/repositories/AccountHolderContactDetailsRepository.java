package com.meritamerica.assignment7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment7.models.AccountHolderContactDetails;

public interface AccountHolderContactDetailsRepository extends JpaRepository<AccountHolderContactDetails, Integer> {
	AccountHolderContactDetails findByAccountHolder(int id);
}
