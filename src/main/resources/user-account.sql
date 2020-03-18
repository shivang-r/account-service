CREATE TABLE `user_account` (
  `account_num` char(9) NOT NULL,
  `first_name` varchar(35) DEFAULT NULL,
  `last_name` varchar(35) DEFAULT NULL,
  `ssn` char(11) DEFAULT NULL,
  `dob` char(10) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `mobile_number` char(12) DEFAULT NULL,
  `home_address` varchar(45) DEFAULT NULL,
  `mailing_address` varchar(45) DEFAULT NULL,
  `account_type` char(10) DEFAULT NULL,
  `min_bal` double DEFAULT NULL,
  PRIMARY KEY (`account_num`),
  UNIQUE KEY `first_name_UNIQUE` (`first_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='table to store user account details';