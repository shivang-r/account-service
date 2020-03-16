package com.account.controller;

import javax.validation.Valid;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.dto.AccountRegistration;
import com.account.dto.AccountRegistrationResponse;
import com.account.exception.AccountRegistrationException;
import com.account.service.AccountService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping(value = "/account")
public class AccountRegistrationController {

	@Autowired
	AccountService accountService;

	@GetMapping(value = "/name")
	public String getServiceName() {
		return "account service";
	}

	@PostMapping(value = "/create")
	public AccountRegistrationResponse createAccount(@Valid @RequestBody AccountRegistration accountInput) {
		log.info("In account Registration");
		AccountRegistrationResponse accountRegistrationResponse = null;
		try {
			accountRegistrationResponse = new AccountRegistrationResponse();
			accountRegistrationResponse = accountService.createAccount(accountInput);
			accountRegistrationResponse.setSuccess(true);

		} catch (AccountRegistrationException ex) {
			log.error("Exception occurred while creating new Account " + ExceptionUtils.getStackTrace(ex));
			accountRegistrationResponse.setExceptionDetails("Runtime Exception Occurred: " + ex.getMessage());
			accountRegistrationResponse.setSuccess(false);
		}

		return accountRegistrationResponse;

	}

}
