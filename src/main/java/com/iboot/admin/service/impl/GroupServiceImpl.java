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
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

  private GroupRepository groupRepository;
  @Autowired
  public void setGroupRepository(GroupRepository groupRepository) {
    this.groupRepository = groupRepository;
  }

  @Override
  public void insert(Group group) {
    groupRepository.save(group);
  }

  @Override
  public void update(Group group) {
    groupRepository.save(group);
  }

  @Override
  public void delete(Integer id) {
    groupRepository.deleteById(id);
  }

  @Override
  public Optional<Group> findById(Integer id) {
    return groupRepository.findById(id);
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
