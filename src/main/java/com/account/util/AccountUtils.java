package com.account.util;

import java.util.StringJoiner;

import org.apache.commons.lang3.RandomStringUtils;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AccountUtils {
	
	public static String generateAccNumber() {
		String commonPrefix  = "73";
		String randomNumber = RandomStringUtils.randomNumeric(7);
		log.info("generated random number - "+randomNumber);
		//String accNumber = String.join(commonPrefix, randomNumber);
		StringJoiner joiner = new StringJoiner("");
		joiner.add(commonPrefix);
		joiner.add(randomNumber);
		String accNumber = joiner.toString();
		log.info("generated accNumber - "+accNumber);
		return accNumber;
	}
}
