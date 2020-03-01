package com.iboot.admin.repository;

import com.iboot.admin.domain.Group;
import com.iboot.admin.domain.Role;
import com.iboot.core.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends BaseRepository<Role,Integer> {


}
