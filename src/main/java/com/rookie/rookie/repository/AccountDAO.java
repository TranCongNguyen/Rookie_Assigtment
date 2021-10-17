package com.rookie.rookie.repository;

import com.rookie.rookie.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<Account,String> {
}
