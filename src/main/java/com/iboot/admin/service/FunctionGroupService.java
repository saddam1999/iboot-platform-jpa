package com.iboot.admin.service;

import com.iboot.admin.domain.FunctionGroup;
import com.iboot.admin.domain.Group;

import java.util.Optional;

public interface FunctionGroupService {
    void insert(FunctionGroup functionGroup);
    void update(FunctionGroup functionGroup);
    void delete(Integer id);
    Optional<FunctionGroup> findById(Integer id);
}
