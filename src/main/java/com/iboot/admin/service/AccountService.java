package com.iboot.admin.service;

import com.iboot.admin.domain.Account;

import java.util.List;
import java.util.Map;

public interface AccountService {
  void insert(Account user);
  List<Account> query();
  List<Map<String, Object>> queryMap();
}
