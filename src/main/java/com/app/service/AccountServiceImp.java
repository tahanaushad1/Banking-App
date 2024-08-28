package com.app.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.AccountDTO;
import com.app.entity.Account;
import com.app.mapper.AccountMapper;
import com.app.repository.AccountRepo;
@Service
public class AccountServiceImp implements AccountService {
	@Autowired
	private AccountRepo accountRepo;

	@Override
	public AccountDTO create(AccountDTO accountDTO) {
		Account account=AccountMapper.mapToAccount(accountDTO);
		Account save = accountRepo.save(account);
		return AccountMapper.mapToAccountDTO(save);
	}

	@Override
	public AccountDTO getAccount(int id) {
	    Account account = accountRepo
	    		.findById(id)
	    		.orElseThrow(() ->new RuntimeException("Id is not exist"));
	 
		return AccountMapper.mapToAccountDTO(account);
	}

	@Override
	public AccountDTO deposit(int id, double amount) {
		Account account = accountRepo
	    		.findById(id)
	    		.orElseThrow(() ->new RuntimeException("Id is not exist"));
	 
		double total=account.getBalanced()+amount;
		account.setBalanced(total);
		Account save = accountRepo.save(account);
		return AccountMapper.mapToAccountDTO(save);
	}

	@Override
	public AccountDTO withdraw(int id, double amount) {
		Account account = accountRepo
	    		.findById(id)
	    		.orElseThrow(() ->new RuntimeException("Id is not exist"));
		if(account.getBalanced()<amount) {
			throw new RuntimeException("Insufficent Balanced");
		}
		double total=account.getBalanced()-amount;
		account.setBalanced(total);
		Account save = accountRepo.save(account);
		return AccountMapper.mapToAccountDTO(save);
	}

	@Override
	public List<AccountDTO> getAllAccount() {
		List<Account> all = accountRepo.findAll();
		return all.stream().map((account)->AccountMapper.mapToAccountDTO(account))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteAccount(int id) {
		Account account = accountRepo
	    		.findById(id)
	    		.orElseThrow(() ->new RuntimeException("Id is not exist"));
		accountRepo.deleteById(id);
	 
	}

	

	

}
