package com.account.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)

@Getter
@Setter
public class AccountRegistrationResponse {

	private String accountNumber;
	private boolean isSuccess;
	private String exceptionDetails;
	private List<Account> accountList;
	private Account account;

}
