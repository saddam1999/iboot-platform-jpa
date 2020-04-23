package com.iboot.admin.service;

import com.iboot.admin.domain.Group;
import com.iboot.admin.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface GroupService {
  void insert(Group group);
  void update(Group group);
  void delete(Long id);
  Optional<Group> findById(Long id);




  List<Group> query();
  List<Map<String, Object>> queryMap();
}
