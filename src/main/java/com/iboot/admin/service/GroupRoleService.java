package com.iboot.admin.service;

import com.iboot.admin.domain.Group;
import com.iboot.admin.domain.GroupRole;
import com.iboot.admin.domain.keyclass.GroupRoleKey;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface GroupRoleService {
  void insert(GroupRole groupRole);
  void update(GroupRole groupRole);
  void delete(GroupRoleKey groupRoleKey);
  Optional<GroupRole> findById(GroupRoleKey groupRoleKey);
}
