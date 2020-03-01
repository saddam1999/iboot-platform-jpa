package com.iboot.admin.repository;

import com.iboot.admin.domain.RoleFunction;
import com.iboot.admin.domain.RoleFunctionGroup;
import com.iboot.admin.domain.keyclass.RoleFunctionGroupKey;
import com.iboot.core.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleFunctionGroupRepository extends BaseRepository<RoleFunctionGroup, RoleFunctionGroupKey> {


}
