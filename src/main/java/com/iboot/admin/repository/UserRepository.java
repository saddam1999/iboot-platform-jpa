package com.iboot.admin.repository;

import com.iboot.admin.domain.User;
import com.iboot.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User,Long> {
}
