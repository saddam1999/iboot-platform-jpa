package com.iboot.admin.service.impl;

import com.iboot.admin.domain.Function;
import com.iboot.admin.domain.FunctionGroup;
import com.iboot.admin.domain.keyclass.FunctionKey;
import com.iboot.admin.repository.FunctionGroupRepository;
import com.iboot.admin.repository.FunctionRepository;
import com.iboot.admin.service.FunctionGroupService;
import com.iboot.admin.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FunctionServiceImpl implements FunctionService {

    private FunctionRepository functionRepository;
    @Autowired
    public void setFunctionRepository(FunctionRepository functionRepository) {
        this.functionRepository = functionRepository;
    }

    @Override
    public void insert(Function function) {
        functionRepository.save(function);
    }

    @Override
    public void update(Function function) {
        functionRepository.save(function);
    }

    @Override
    public void delete(FunctionKey functionKey) {
        functionRepository.deleteById(functionKey);
    }

    @Override
    public Optional<Function> findById(FunctionKey functionKey) {
        return functionRepository.findById(functionKey);
    }
}
