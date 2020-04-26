package com.iboot.admin.service;

import com.iboot.admin.domain.Function;
import com.iboot.admin.domain.RoleFunction;
import com.iboot.admin.domain.keyclass.FunctionKey;
import com.iboot.admin.domain.keyclass.RoleFunctionKey;

import java.util.Optional;

public interface RoleFunctionService {
    void insert(RoleFunction roleFunction);
    void update(RoleFunction roleFunction);
    void delete(Long id);
    Optional<RoleFunction> findById(Long id);
}
