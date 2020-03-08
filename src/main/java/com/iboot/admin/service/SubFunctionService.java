package com.iboot.admin.service;

import com.iboot.admin.domain.Function;
import com.iboot.admin.domain.RoleFunction;
import com.iboot.admin.domain.SubFunction;
import com.iboot.admin.domain.keyclass.RoleFunctionKey;
import com.iboot.admin.domain.keyclass.SubFunctionKey;

import java.util.Optional;

public interface SubFunctionService {
    void insert(SubFunction subFunction);
    void update(SubFunction subFunction);
    void delete(SubFunctionKey subFunctionKey);
    Optional<SubFunction> findById(SubFunctionKey subFunctionKey);
}
