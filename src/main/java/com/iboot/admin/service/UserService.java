package com.iboot.admin.service;

import com.iboot.admin.domain.Function;
import com.iboot.admin.domain.SubFunction;
import com.iboot.admin.domain.User;
import com.iboot.admin.domain.keyclass.SubFunctionKey;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {
  void insert(User user);
  void update(User user);
  void delete(Long id);
  Optional<Function> findById(Long id);


  List<User> query(String sql);
  List<Map<String, Object>> queryMap();
}
