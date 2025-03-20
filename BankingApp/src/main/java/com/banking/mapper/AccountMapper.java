package com.banking.mapper;

import com.banking.dto.AccountDto;
import com.banking.entities.Account;

public class AccountMapper {
	public static Account maptoAccount(AccountDto accountDto) {
		Account account = new Account(accountDto.getId(), accountDto.getName(), accountDto.getBalance());

		return account;
	}

	public static AccountDto maptoAccountDto(Account account) {

		AccountDto accountDto = new AccountDto(account.getId(), account.getName(), account.getBalance());
		return accountDto;
	}
}
