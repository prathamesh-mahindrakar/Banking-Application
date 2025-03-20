package com.banking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.dto.AccountDto;
import com.banking.service.AccountService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class AccountController {
	
	private AccountService accountService;
	
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	@PostMapping("/account")
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
		return new ResponseEntity<> (accountService.createAccount(accountDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/account/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
		return new ResponseEntity<>(accountService.getAccountById(id),HttpStatus.OK);
		
	}
	
	@PutMapping("/account/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
	    Double amount = request.get("amount");

	    return new ResponseEntity<>(accountService.deposit(id, amount), HttpStatus.OK);
	}

	
	@PutMapping("/account/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		//TODO: process POST request
	    Double amount = request.get("amount");
	    return new ResponseEntity<>(accountService.withdraw(id, amount), HttpStatus.OK);
	}
	
	@GetMapping("/account")
	public ResponseEntity<List<AccountDto>> getAllAccounts() {
	 List<AccountDto> getAcc =	accountService.getAllAccounts();
	 return ResponseEntity.ok(getAcc);
	}
	
	@DeleteMapping("/account/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
		accountService.deleteAccount(id);
		return ResponseEntity.ok("Account deleted Successfully");
	}
	
	
}
