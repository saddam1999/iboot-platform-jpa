package com.iboot.admin.repository;

import com.iboot.admin.domain.Function;
import com.iboot.admin.domain.Group;
import com.iboot.admin.domain.keyclass.FunctionKey;
import com.iboot.core.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FunctionRepository extends BaseRepository<Function, Long> {


}
