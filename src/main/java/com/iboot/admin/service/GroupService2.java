package com.iboot.admin.service;

import com.iboot.admin.domain.Group;
import com.iboot.core.service.BaseService;

import java.util.List;
import java.util.Map;

public interface GroupService2 extends BaseService<Group,Long> {
  List<Group> query();
  List<Map<String, Object>> queryMap();
}
