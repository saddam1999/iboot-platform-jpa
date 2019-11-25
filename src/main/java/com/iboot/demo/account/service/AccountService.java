package com.iboot.demo.account.service;

import com.iboot.admin.domain.User;
import com.iboot.demo.account.domain.Account;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AccountService {
   Account save(Account account);
   void deleteById(String accountId);
   Account saveAndFlush(Account account);
   Optional<Account> findById(String accountId);
   Account findAccountByUsername(String username);
   Account findAccountByName(String username);
   Account findAccountByEmail(String email);
   Account getAccount(String username);
}
