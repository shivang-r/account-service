package com.account.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "user_account")
public class Account {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_num")
	private String accountNum;

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String ssn;
	private String dob;
	
	@Column(name="email")
	private String emailId;
	
	@Column(name="mobile_number")
	private String mobileNumber;
	
	@Column(name="home_address")
	private String homeAddress;
	
	@Column(name="mailing_address")
	private String mailingAddress;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="min_bal")
	private double minBalance;
}
