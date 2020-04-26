package com.iboot.admin.service;

import com.iboot.admin.domain.Function;
import com.iboot.admin.domain.FunctionGroup;
import com.iboot.admin.domain.keyclass.FunctionKey;

import java.util.Optional;

public interface FunctionService {
    void insert(Function function);
    void update(Function function);
    void delete(Long id);
    Optional<Function> findById(Long id);
}
