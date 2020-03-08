package com.iboot.admin.service.impl;

import com.iboot.admin.domain.Function;
import com.iboot.admin.domain.User;
import com.iboot.admin.repository.UserRepository;
import com.iboot.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;
  @Autowired
  public void setUserRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void insert(User user) {
    userRepository.save(user);
  }

  @Override
  public void update(User user) {
    userRepository.save(user);
  }

  @Override
  public void delete(Long id) {
    userRepository.deleteById(id);
  }

  @Override
  public Optional<Function> findById(Long id) {
    return Optional.empty();
  }

  @Override
  public List<User> query(String sql) {
    return userRepository.query(sql);
  }

  @Override
  public List<Map<String, Object>> queryMap() {
    return userRepository.queryForMap("select * from tbuser");
  }

}
