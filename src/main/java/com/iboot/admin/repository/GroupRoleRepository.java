package com.iboot.admin.repository;

import com.iboot.admin.domain.Group;
import com.iboot.admin.domain.GroupRole;
import com.iboot.admin.domain.keyclass.GroupRoleKey;
import com.iboot.core.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRoleRepository extends BaseRepository<GroupRole, GroupRoleKey> {
}
