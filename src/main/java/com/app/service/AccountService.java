package com.app.service;

import java.util.List;

import com.app.dto.AccountDTO;
import com.app.entity.Account;

public interface AccountService {
	public AccountDTO create(AccountDTO accountDTO);
	public AccountDTO getAccount(int id);
	public AccountDTO deposit(int id,double amount);
	public AccountDTO withdraw(int id, double amount);
	public List<AccountDTO>getAllAccount();
	public void deleteAccount(int id);

}
