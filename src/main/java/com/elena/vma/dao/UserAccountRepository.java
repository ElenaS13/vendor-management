package com.elena.vma.dao;

import org.springframework.data.repository.CrudRepository;

import com.elena.vma.entities.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

	

}
