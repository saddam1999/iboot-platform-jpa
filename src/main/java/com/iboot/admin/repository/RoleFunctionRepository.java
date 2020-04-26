package com.iboot.admin.repository;

import com.iboot.admin.domain.Role;
import com.iboot.admin.domain.RoleFunction;
import com.iboot.admin.domain.keyclass.RoleFunctionGroupKey;
import com.iboot.admin.domain.keyclass.RoleFunctionKey;
import com.iboot.core.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleFunctionRepository extends BaseRepository<RoleFunction, Long> {


}
