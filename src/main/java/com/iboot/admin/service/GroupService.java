package com.iboot.admin.service;

import com.iboot.admin.domain.Group;
import com.iboot.admin.domain.User;
import com.iboot.core.service.BaseService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface GroupService  {
  List<Group> query();
  List<Map<String, Object>> queryMap();
}
