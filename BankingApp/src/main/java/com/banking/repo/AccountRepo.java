package com.banking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.entities.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>{

}
