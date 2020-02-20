package com.iboot.base.service.impl;

import com.iboot.admin.domain.User;
import com.iboot.admin.repository.UserRepository;
import com.iboot.admin.service.UserService;
import com.iboot.base.domain.BaseP01;
import com.iboot.base.domain.BaseP02;
import com.iboot.base.domain.keyclass.BaseP02Key;
import com.iboot.base.repository.BaseP02Repository;
import com.iboot.base.service.BaseP01Service;
import com.iboot.base.service.BaseP02Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BaseP02ServiceImpl implements BaseP02Service {

  @Autowired
  BaseP02Repository baseP02Repository;

  @Override
  public void insert(BaseP02 baseP02) {
    baseP02Repository.save(baseP02);
  }

  @Override
  public Optional<BaseP02> findById(BaseP02Key baseP02Key) {
    return baseP02Repository.findById(baseP02Key);
  }

  @Override
  public List<BaseP02> query() {
    return baseP02Repository.query("select * from TBBASEP02");
  }

  @Override
  public List<Map<String, Object>> queryMap() {
    return baseP02Repository.queryForMap("select * from TBBASEP02");
  }

}
