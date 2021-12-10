package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Account;

public interface AccountService {
	Account saveAccount(Account account);
	List<Account> getAllAccount();
	Account getAccountById(long id);
	Account updateAccount(Account account, long id);
	void deleteAccount(long id);

}


