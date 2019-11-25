package com.iboot.demo.account.service;

import com.iboot.admin.domain.User;
import com.iboot.admin.repository.UserRepository;
import com.iboot.demo.account.domain.Account;
import com.iboot.demo.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

  @Autowired
  AccountRepository accountRepository;


  @Override
  public Account save(Account account) {
    return accountRepository.save(account);
  }

  @Override
  public void deleteById(String accountId) {
     accountRepository.deleteById(accountId);
  }

  @Override
  public Account saveAndFlush(Account account) {
    return accountRepository.saveAndFlush(account);
  }

  @Override
  public Optional<Account> findById(String accountId) {
    return accountRepository.findById(accountId);
  }

  @Override
  public Account findAccountByUsername(String username) {
    return accountRepository.findAccountByUsername(username);
  }

  @Override
  public Account findAccountByName(String username) {
    return accountRepository.findAccountByName(username);
  }

  @Override
  public Account findAccountByEmail(String email) {
    return accountRepository.findAccountByEmail(email);
  }

  @Override
  public Account getAccount(String username) {
    return accountRepository.getAccount(username);
  }
}
