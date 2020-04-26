package com.iboot.admin.repository;

import com.iboot.admin.domain.RoleFunction;
import com.iboot.admin.domain.SubFunction;
import com.iboot.admin.domain.keyclass.RoleFunctionKey;
import com.iboot.admin.domain.keyclass.SubFunctionKey;
import com.iboot.core.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubFunctionRepository extends BaseRepository<SubFunction, Long> {


}
