package com.capgemini.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientInitialAmountException;
import com.capgemini.repo.AccountRepo;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;
import static org.mockito.Mockito.when;
public class AccountServiceTest {
	
	@Mock
	AccountRepo accountRepo;
	
	AccountService accountService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		accountService = new AccountServiceImpl(accountRepo);
	}
	
	/*
	 * 1. when the amount is less than 500 system should throw exception
	 * 2. when the valid info is passed account should be created successfully
	 */
	
	
	@Test(expected=com.capgemini.exceptions.InsufficientInitialAmountException.class)
	public void whenTheAmountIsLessThanFiveHundredSystemShouldThrowException() throws InsufficientInitialAmountException
	{
		accountService.createAccount(101, 300);
	}
	
	@Test
	public void whenTheValidInfoIsPassedAccountShouldBeCreatedSuccessfully() throws InsufficientInitialAmountException
	{
		Account account =new Account();
		account.setAccountNumber(101);
		account.setAmount(5000);
		
		when(accountRepo.save(account)).thenReturn(true);
		assertEquals(account,accountService.createAccount(101,5000));
	}

	

}
