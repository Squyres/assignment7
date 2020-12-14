package com.meritamerica.assignment5;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountHolderReposity extends JpaRepository<AccountHolder, Integer>{
	
	AccountHolder findById(int id);

}
