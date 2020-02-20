package com.iboot.base.service.impl;

import com.iboot.admin.domain.Group;
import com.iboot.admin.repository.GroupRepository;
import com.iboot.admin.service.GroupService;
import com.iboot.base.domain.BaseP01;
import com.iboot.base.repository.BaseP01Repository;
import com.iboot.base.service.BaseP01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BaseP01ServiceImpl implements BaseP01Service {

  @Autowired
  BaseP01Repository baseP01Repository;

  @Override
  public void insert(BaseP01 baseP01) {
    baseP01Repository.save(baseP01);
  }

  @Override
  public List<BaseP01> query() {
    return baseP01Repository.query("select * from TBBASEP01 ");
  }

  @Override
  public List<Map<String, Object>> queryMap() {
    return baseP01Repository.queryForMap("select * from TBBASEP01 ");
  }

}
