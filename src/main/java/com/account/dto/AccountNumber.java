package com.account.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AccountNumber {

	private String accNum;

	public AccountNumber(String accNum) {
		super();
		this.accNum = accNum;
	}
}
