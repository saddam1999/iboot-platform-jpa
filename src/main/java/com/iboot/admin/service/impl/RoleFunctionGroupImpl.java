package com.iboot.admin.service.impl;

import com.iboot.admin.domain.RoleFunctionGroup;
import com.iboot.admin.domain.keyclass.RoleFunctionGroupKey;
import com.iboot.admin.repository.RoleFunctionGroupRepository;
import com.iboot.admin.service.RoleFunctionGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleFunctionGroupImpl implements RoleFunctionGroupService {

    private RoleFunctionGroupRepository roleFunctionGroupRepository;
    @Autowired
    public void setRoleFunctionGroupRepository(RoleFunctionGroupRepository roleFunctionGroupRepository) {
        this.roleFunctionGroupRepository = roleFunctionGroupRepository;
    }


    @Override
    public void insert(RoleFunctionGroup roleFunctionGroup) {
        roleFunctionGroupRepository.save(roleFunctionGroup);
    }

    @Override
    public void update(RoleFunctionGroup roleFunctionGroup) {
        roleFunctionGroupRepository.save(roleFunctionGroup);
    }

    @Override
    public void delete(RoleFunctionGroupKey roleFunctionGroupKey) {
        roleFunctionGroupRepository.deleteById(roleFunctionGroupKey);
    }

    @Override
    public Optional<RoleFunctionGroup> findById(RoleFunctionGroupKey roleFunctionGroupKey) {
        return roleFunctionGroupRepository.findById(roleFunctionGroupKey);
    }
}
