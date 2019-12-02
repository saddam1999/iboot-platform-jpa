package com.iboot.demo.account.service;

import com.iboot.demo.account.domain.AccountDemo;
import com.iboot.demo.account.repository.AccountDemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountDemoServiceImpl implements AccountDemoService {

  @Autowired
  AccountDemoRepository accountDemoRepository;


  @Override
  public List<AccountDemo> findAll() {
    return accountDemoRepository.findAll();
  }

  @Override
  public AccountDemo save(AccountDemo accountDemo) {
    return accountDemoRepository.save(accountDemo);
  }

  @Override
  public void deleteById(String accountId) {
     accountDemoRepository.deleteById(accountId);
  }

  @Override
  public AccountDemo saveAndFlush(AccountDemo accountDemo) {
    return accountDemoRepository.saveAndFlush(accountDemo);
  }

  @Override
  public Optional<AccountDemo> findById(String accountId) {
    return accountDemoRepository.findById(accountId);
  }

  @Override
  public AccountDemo findAccountByUsername(String userName) {
    return accountDemoRepository.findAccountByUserName(userName);
  }

  @Override
  public AccountDemo findAccountByName(String userName) {
    return accountDemoRepository.findAccountByName(userName);
  }

  @Override
  public AccountDemo findAccountByEmail(String email) {
    return accountDemoRepository.findAccountByEmail(email);
  }

  @Override
  public AccountDemo getAccount(String userName) {
    return accountDemoRepository.getAccount(userName);
  }
}
