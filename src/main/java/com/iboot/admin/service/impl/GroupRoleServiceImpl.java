package com.iboot.admin.service.impl;

import com.iboot.admin.domain.GroupRole;
import com.iboot.admin.domain.keyclass.GroupRoleKey;
import com.iboot.admin.repository.GroupRoleRepository;
import com.iboot.admin.service.GroupRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupRoleServiceImpl implements GroupRoleService {
    private GroupRoleRepository groupRoleRepository;
    @Autowired
    public void setGroupRoleRepository(GroupRoleRepository groupRoleRepository) {
        this.groupRoleRepository = groupRoleRepository;
    }



    @Override
    public void insert(GroupRole groupRole) {
        groupRoleRepository.save(groupRole);
    }

    @Override
    public void update(GroupRole groupRole) {
        groupRoleRepository.save(groupRole);
    }

    @Override
    public void delete(GroupRoleKey groupRoleKey) {
        groupRoleRepository.deleteById(groupRoleKey);
    }

    @Override
    public Optional<GroupRole> findById(GroupRoleKey groupRoleKey) {
        return groupRoleRepository.findById(groupRoleKey);
    }
}
