package com.iboot.admin.service;

import com.iboot.admin.domain.RoleFunctionGroup;
import com.iboot.admin.domain.keyclass.RoleFunctionGroupKey;

import java.util.Optional;

public interface RoleFunctionGroupService {
    void insert(RoleFunctionGroup roleFunctionGroup);
    void update(RoleFunctionGroup roleFunctionGroup);
    void delete(RoleFunctionGroupKey roleFunctionGroupKey);
    Optional<RoleFunctionGroup> findById(RoleFunctionGroupKey roleFunctionGroupKey);
}
