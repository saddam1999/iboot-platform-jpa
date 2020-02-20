package com.iboot.admin.service.impl;

import com.iboot.admin.domain.Group;
import com.iboot.admin.domain.User;
import com.iboot.admin.repository.GroupRepository;
import com.iboot.admin.repository.UserRepository;
import com.iboot.admin.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GroupServiceImpl implements GroupService {

  @Autowired
  GroupRepository groupRepository;

  @Override
  public void insert(Group user) {
    groupRepository.save(user);
  }

  @Override
  public List<Group> query() {
    return groupRepository.query("select * from tbgroup");
  }

  @Override
  public List<Map<String, Object>> queryMap() {
    return groupRepository.queryForMap("select * from tbgroup");
  }

}
