package com.iboot.admin.repository;

import com.iboot.admin.domain.User;
import com.iboot.core.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User,Long> {
}
