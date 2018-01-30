package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientInitialAmountException;
import com.capgemini.repo.AccountRepo;

public class AccountServiceImpl implements AccountService {
	
	AccountRepo accountRepo;
	
	
	public AccountServiceImpl(AccountRepo accountRepo) {
		super();
		this.accountRepo = accountRepo;
	}


	/* (non-Javadoc)
	 * @see com.capgemini.service.AccountService#createAccount(int, int)
	 */
	@Override
	public Account createAccount(int accountNumber,int amount)throws InsufficientInitialAmountException
	{
		if(amount<500)
		{
			throw new InsufficientInitialAmountException();
		}
		
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		
		if(accountRepo.save(account))
		{
			return account;
		}
		
		return null;
	}

}
