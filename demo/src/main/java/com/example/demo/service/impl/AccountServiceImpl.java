package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;

@Service
public class AccountServiceImpl  implements AccountService {

	private AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public Account saveAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}
	
//	@Override
//	public List<Account> getAccountByholdingName() {
//		return accountRepository.findAll(Sort.by("holdingName"));
//	}
	
//	@Override
//	public List<Account> getAccountByholdingId() {
//		return accountRepository.findAll(Sort.by("hid"));
//	}

	@Override
	public Account updateAccount(Account account, long id) {
		
		Account existingaccount = accountRepository.findById(id).orElseThrow(
			() ->new AccountNotFoundException("Account", "Id", id)	);
		
		existingaccount.setAccountName(account.getAccountName());
		existingaccount.setProfileId(account.getProfileId());
		existingaccount.setTotalBalance(account.getTotalBalance());
		
		accountRepository.save(existingaccount);
		
		return existingaccount;
	}

	@Override
	public Account getAccountById(long id) {
		return accountRepository.findById(id).orElseThrow(
				() ->new AccountNotFoundException("Account", "Id", id));
	}

	@Override
	public void deleteAccount(long id) {
		
		Account existingaccount = accountRepository.findById(id).orElseThrow(
				() ->new AccountNotFoundException("Account", "Id", id)	);
		
		accountRepository.deleteById(id);
		
	}



	

}
