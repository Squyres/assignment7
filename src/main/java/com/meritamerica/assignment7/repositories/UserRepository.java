package com.meritamerica.assignment7.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment7.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserName(String userName);
	User findById(int id);

}