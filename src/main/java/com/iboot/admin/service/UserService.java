package com.iboot.admin.service;

import com.iboot.admin.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
  void insert(User user);
  List<User> query();
  List<Map<String, Object>> queryMap();
}
