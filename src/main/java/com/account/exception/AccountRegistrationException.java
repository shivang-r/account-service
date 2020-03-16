package com.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class AccountRegistrationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AccountRegistrationException(String message) {
		super(message);
	}

}
