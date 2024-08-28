package com.app.mapper;

import com.app.dto.AccountDTO;
import com.app.entity.Account;

public class AccountMapper {
	public static Account mapToAccount(AccountDTO accountDTO) {
		Account account =new Account(
				accountDTO.getId(),
				accountDTO.getAccountHolderName(),
				accountDTO.getBalanced()
				
				);
		return account;
	}
	public static AccountDTO mapToAccountDTO(Account account) {
		AccountDTO accountDTO=new AccountDTO(
				account.getId(),
				account.getAccountHolderName(),
				account.getBalanced()
				
				);
		return accountDTO;
	}

}
