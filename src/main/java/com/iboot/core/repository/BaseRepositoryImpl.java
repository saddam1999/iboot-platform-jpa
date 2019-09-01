package com.iboot.core.repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;


@Repository
public class BaseRepositoryImpl extends NamedParameterJdbcTemplate implements BaseRepository {
  public BaseRepositoryImpl(final DataSource dataSource) {
    super(dataSource);
  }
}
