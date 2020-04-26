package com.iboot.admin.service.impl;

import com.iboot.admin.domain.FunctionGroup;
import com.iboot.admin.repository.FunctionGroupRepository;
import com.iboot.admin.service.FunctionGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FunctionGroupServiceImpl implements FunctionGroupService {

    private FunctionGroupRepository functionGroupRepository;
    @Autowired
    public void setFunctionGroupRepository(FunctionGroupRepository functionGroupRepository){
        this.functionGroupRepository = functionGroupRepository;
    }

    @Override
    public void insert(FunctionGroup functionGroup) {
        functionGroupRepository.save(functionGroup);
    }

    @Override
    public void update(FunctionGroup functionGroup) {
        functionGroupRepository.save(functionGroup);
    }

    @Override
    public void delete(Long id) {
        functionGroupRepository.deleteById(id);
    }

    @Override
    public Optional<FunctionGroup> findById(Long id) {
        return functionGroupRepository.findById(id);
    }
}
