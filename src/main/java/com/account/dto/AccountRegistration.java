package com.account.dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.*;

@Getter @Setter
public class AccountRegistration {
	
	@NotEmpty(message="Please provide the first name")
	private String firstName;
	
	@NotEmpty(message="Please provide the last name")
	private String lastName;
	
	@NotEmpty(message="Please provide ssn")
	@Size(min=9, max=9) //TODO check if ssn length varies. use @Column(length=9) here instead of @Size 
	private String ssn;
	
	@NotEmpty(message="Please provide date of birth")
	private String dob;
	
	@NotEmpty(message="Please provide email Id")
	private String emailId;
	
	@NotEmpty(message="Please provide mobile number")
	@Size(min=10, max=10)
	private String mobileNumber;
	
	@NotEmpty(message="Please provide home address")
	private String homeAddress;
	
	@NotEmpty(message="Please provide mailing address")
	private String mailingAddress;
	
	@NotEmpty(message="Please provide type of account")
	private String accountType;
	
	@Min(value=0L, message="minimum balance must be positive")
	private double minBalance;

}
