package com.iboot.admin.service;

import com.iboot.admin.domain.Group;
import com.iboot.admin.domain.Role;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface RoleService {
  void insert(Role role);
  void update(Role role);
  void delete(Long id);
  Optional<Role> findById(Long id);
}
