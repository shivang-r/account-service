package com.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.account.dto.Account;
import com.account.dto.AccountRegistration;
import com.account.dto.AccountRegistrationResponse;
import com.account.repository.AccountCrudRepository;
import com.account.util.AccountUtils;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AccountService {

	@Autowired
	AccountCrudRepository accountCrudRepository;

	public AccountRegistrationResponse createAccount(AccountRegistration userInput) {

		Account accountInput = populateAccountEntity(userInput);
		accountCrudRepository.save(accountInput);
	    AccountRegistrationResponse response = new AccountRegistrationResponse();
		response.setAccountNumber(String.valueOf(accountInput.getAccountNum()));
		response.setSuccess(true);
		log.info("Account registered");
		return response;
	}

	private Account populateAccountEntity(AccountRegistration userInput) {

		Account accountEntity = new Account();
		accountEntity.setAccountNum(AccountUtils.generateAccNumber());
		accountEntity.setFirstName(userInput.getFirstName());
		accountEntity.setLastName(userInput.getLastName());
		accountEntity.setDob(userInput.getDob());
		accountEntity.setEmailId(userInput.getEmailId());
		accountEntity.setAccountType(userInput.getAccountType());
		accountEntity.setHomeAddress(userInput.getHomeAddress());
		accountEntity.setMailingAddress(userInput.getMailingAddress());
		accountEntity.setMinBalance(userInput.getMinBalance());
		accountEntity.setMobileNumber(userInput.getMobileNumber());
		accountEntity.setSsn(userInput.getSsn());
		return accountEntity;
	}
	
}
