package com.iboot.admin.service;

import com.iboot.admin.domain.User;
import com.iboot.admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository userRepository;

  @Override
  public void insert(User user) {
    userRepository.save(user);
  }

  @Override
  public List<User> query() {
    return userRepository.query("select * from tbuser");
  }

  @Override
  public List<Map<String, Object>> queryMap() {
    return userRepository.queryForMap("select * from tbuser");
  }

}
