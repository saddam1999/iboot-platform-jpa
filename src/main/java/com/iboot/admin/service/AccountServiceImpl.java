package com.iboot.admin.service;

import com.iboot.admin.domain.Account;
import com.iboot.admin.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {

  @Autowired
  AccountRepository userRepository;

  @Override
  public void insert(Account user) {
    userRepository.save(user);
  }

  @Override
  public List<Account> query() {
    return userRepository.query("select * from user");
  }

  @Override
  public List<Map<String, Object>> queryMap() {
    return userRepository.queryForMap("select * from user");
  }

}
