package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {
	

}
