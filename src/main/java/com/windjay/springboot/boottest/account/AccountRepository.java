package com.windjay.springboot.boottest.account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
  Account findByUsername(String username);
}
