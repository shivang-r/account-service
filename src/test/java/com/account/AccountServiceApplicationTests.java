package com.account;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.account.controller.AccountRegistrationController;
import com.account.dto.AccountRegistration;
import com.account.dto.AccountRegistrationResponse;
import com.account.repository.AccountCrudRepository;
import com.account.service.AccountService;
import com.account.util.AccountUtils;

@SpringBootTest
class AccountServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mockmvc;

	@MockBean
	private AccountService accountService;

	@MockBean
	private AccountCrudRepository accountCrudRepository;
	
	@BeforeEach
	public void setup() {
		mockmvc = MockMvcBuilders.standaloneSetup(new AccountRegistrationController()).build();
	}

	@Test
	public void createAccount() throws Exception {

		AccountRegistration account = new AccountRegistration();

		account.setAccountType("Savings");
		account.setDob("10-02-1980");
		account.setEmailId("shiv.rathod@gmail.com");
		account.setFirstName("shiva");
		account.setLastName("rathod");
		account.setHomeAddress("2535 Boardwalk blvd, Hoffman Estates, IL-60169");
		account.setMailingAddress("2000 S Roselle Rd, Schaumburg, IL-60195");
		account.setMobileNumber("224-333-5433");
		account.setMinBalance(43300.00);
		account.setSsn("111-111-1111");

		AccountRegistrationResponse accRegistrResponse = new AccountRegistrationResponse();
		accRegistrResponse.setAccountNumber(AccountUtils.generateAccNumber());
		// accRegistrResponse.setSuccess(true);

		Mockito.when(accountService.createAccount(account)).thenReturn(accRegistrResponse);

		mockmvc.perform(post("/account/create")
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(MockMvcResultMatchers.jsonPath("$.accountNumber").value(accRegistrResponse.getAccountNumber()));

	}

}
