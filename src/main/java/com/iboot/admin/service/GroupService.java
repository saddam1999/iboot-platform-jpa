package com.iboot.admin.service;

import com.iboot.admin.domain.Group;
import com.iboot.admin.domain.User;

import java.util.List;
import java.util.Map;

public interface GroupService {
  void insert(Group group);
  List<Group> query();
  List<Map<String, Object>> queryMap();
}
