package com.iboot.demo.account.service;

import com.iboot.demo.account.domain.AccountDemo;

import java.util.List;
import java.util.Optional;

public interface AccountDemoService {
   List<AccountDemo> findAll();
   AccountDemo save(AccountDemo accountDemo);
   void deleteById(String accountId);
   AccountDemo saveAndFlush(AccountDemo accountDemo);
   Optional<AccountDemo> findById(String accountId);
   AccountDemo findAccountByUsername(String userName);
   AccountDemo findAccountByName(String userName);
   AccountDemo findAccountByEmail(String email);
   AccountDemo getAccount(String userName);

}
