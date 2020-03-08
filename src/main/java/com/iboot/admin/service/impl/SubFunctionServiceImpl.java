package com.iboot.admin.service.impl;

import com.iboot.admin.domain.Function;
import com.iboot.admin.domain.SubFunction;
import com.iboot.admin.domain.keyclass.SubFunctionKey;
import com.iboot.admin.repository.SubFunctionRepository;
import com.iboot.admin.service.SubFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubFunctionServiceImpl implements SubFunctionService {
    private SubFunctionRepository subFunctionRepository;
    @Autowired
    public void setSubFunctionRepository(SubFunctionRepository subFunctionRepository) {
        this.subFunctionRepository = subFunctionRepository;
    }

    @Override
    public void insert(SubFunction subFunction) {
        subFunctionRepository.save(subFunction);
    }

    @Override
    public void update(SubFunction subFunction) {
        subFunctionRepository.save(subFunction);
    }

    @Override
    public void delete(SubFunctionKey subFunctionKey) {
        subFunctionRepository.deleteById(subFunctionKey);
    }

    @Override
    public Optional<SubFunction> findById(SubFunctionKey subFunctionKey) {
        return subFunctionRepository.findById(subFunctionKey);
    }
}
