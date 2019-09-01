package com.iboot.admin.service;

import com.iboot.admin.domain.User;
import com.iboot.core.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private BaseRepository baseRepository;


  @Override
  public void insert(User user) {
    String sql = "insert into t_user(id,name,email) values (:id,:name,:email)";
    baseRepository.update(sql,new BeanPropertySqlParameterSource(user));
  }
}
