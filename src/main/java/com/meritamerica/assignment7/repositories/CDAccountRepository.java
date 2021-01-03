package com.meritamerica.assignment7.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment7.models.CDAccount;

public interface CDAccountRepository extends JpaRepository<CDAccount, Integer> {
	List<CDAccount> findByAccountHolder(int id);

}
