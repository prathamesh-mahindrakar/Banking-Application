package com.banking.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.banking.dto.AccountDto;
import com.banking.entities.Account;
import com.banking.mapper.AccountMapper;
import com.banking.repo.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepo accountRepo;

	public AccountServiceImpl(AccountRepo accountRepo) {
		super();
		this.accountRepo = accountRepo;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.maptoAccount(accountDto);
		Account savedAccount = accountRepo.save(account);

		return AccountMapper.maptoAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		Account account = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account does not Exsist"));
		return AccountMapper.maptoAccountDto(account);
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account1 = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account does not Exsist"));
		double totalBalance = account1.getBalance() + amount;
		account1.setBalance(totalBalance);
		Account savedAccount = accountRepo.save(account1);
		return AccountMapper.maptoAccountDto(savedAccount);

	}

	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account does not Exsist"));
		if (account.getBalance() < amount) {
			throw new RuntimeException("Insuffient Balance");
		}

		double totalBalance = account.getBalance() - amount;
		account.setBalance(totalBalance);
		Account savedAccount = accountRepo.save(account);
		return AccountMapper.maptoAccountDto(savedAccount);

	}

	@Override
	public List<AccountDto> getAllAccounts() {
	 return	accountRepo.findAll().stream().map((account) -> AccountMapper.maptoAccountDto(account))
				.collect(Collectors.toList());

	}

	@Override
	public void deleteAccount(Long id) {
		Account account = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account does not Exsist"));

		accountRepo.delete(account);
		
	}

}
