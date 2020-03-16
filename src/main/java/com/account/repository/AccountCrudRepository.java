package com.account.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.account.dto.Account;

@Transactional
@Repository
public interface AccountCrudRepository extends CrudRepository<Account, String> {
}
