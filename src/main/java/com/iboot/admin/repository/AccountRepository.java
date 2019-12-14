package com.iboot.admin.repository;

import com.iboot.admin.domain.Account;
import com.iboot.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends BaseRepository<Account,Long> {
}
