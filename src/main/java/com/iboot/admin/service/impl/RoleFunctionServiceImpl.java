package com.iboot.admin.service.impl;

import com.iboot.admin.domain.Function;
import com.iboot.admin.domain.RoleFunction;
import com.iboot.admin.domain.keyclass.RoleFunctionKey;
import com.iboot.admin.repository.RoleFunctionRepository;
import com.iboot.admin.service.RoleFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleFunctionServiceImpl implements RoleFunctionService {
    private RoleFunctionRepository roleFunctionRepository;

    @Autowired
    public void setRoleFunctionRepository(RoleFunctionRepository roleFunctionRepository) {
        this.roleFunctionRepository = roleFunctionRepository;
    }


    @Override
    public void insert(RoleFunction roleFunction) {
        roleFunctionRepository.save(roleFunction);
    }

    @Override
    public void update(RoleFunction roleFunction) {
        roleFunctionRepository.save(roleFunction);
    }

    @Override
    public void delete(Long id) {
        roleFunctionRepository.deleteById(id);
    }

    @Override
    public Optional<RoleFunction> findById(Long id) {
        return roleFunctionRepository.findById(id);
    }
}
