package com.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AccountDTO;
import com.app.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {
	@Autowired
	private AccountService accountService;
	@PostMapping("/addAccount")
	public ResponseEntity<AccountDTO>addAccount(@RequestBody AccountDTO accountDTO){
		return new ResponseEntity<AccountDTO>(accountService.create(accountDTO), HttpStatus.CREATED);
		
	}
	@GetMapping("/getById/{id}")
	public ResponseEntity<AccountDTO>getById(@PathVariable int  id){
		AccountDTO account = accountService.getAccount(id);
		return ResponseEntity.ok(account);
	}
	@PutMapping("/deposit/{id}")
	public ResponseEntity<AccountDTO>deposit(@PathVariable int  id,
			                                 @RequestBody Map<String, Double> request){
		Double amount=request.get("amount");
		AccountDTO accountDTO = accountService.deposit(id, amount);
		return ResponseEntity.ok(accountDTO);
		
	}
	@PutMapping("/withdraw/{id}")
	public ResponseEntity<AccountDTO>withdraw(@PathVariable int id,
			                                 @RequestBody Map<String,Double> request){
		Double amount = request.get("amount");
		AccountDTO accountDTO = accountService.withdraw(id, amount);
		return ResponseEntity.ok(accountDTO);
		
	}
	@GetMapping("/getAllAccount")
	public ResponseEntity<List<AccountDTO>>getAllAccount(){
		List<AccountDTO> account = accountService.getAllAccount();
		return ResponseEntity.ok(account);
	}
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int  id){
		accountService.deleteAccount(id);
		return ResponseEntity.ok("Account delete successfully!");
	}
	
	
	

	

}
