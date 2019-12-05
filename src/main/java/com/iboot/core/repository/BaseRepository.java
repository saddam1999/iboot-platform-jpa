package com.iboot.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@NoRepositoryBean
public interface BaseRepository<T,ID extends Serializable> extends JpaRepository<T,ID> , PagingAndSortingRepository<T, ID>
    , JpaSpecificationExecutor<T> {

  /**
   * SQL 查詢後回傳 Object List
   * @param sql
   * @return List<Object[]>
   */
  List<Object[]> queryForList(String sql);


  /**
   * SQL 查詢後回傳 Object List
   * @param sql
   * @return List<Object[]>
   */
  List<Map<String, Object>> queryForMap(String sql);

  /**
   * SQL 查詢 物件, 找不到回傳null
   * @param sql
   * @return Object
   */
  Object queryData(String sql);

  /**
   * SQL 查詢後回傳 VO class 集合
   * @param sql
   * @return
   */
  List<T> query(String sql);


  /**
   * SQL 查詢後回傳 VO class
   * @param sql
   * @return T
   */
  T get(String sql);

  /**
   * 執行sql 語法回傳影響列數
   * @param sql
   * @return int
   */
  int execute(String sql);

  Class<T> getDataClass();


  Page<T> queryPagingResultList(StringBuffer sql, int page, int size, Sort sort);
  Page<Map<String, Object>> queryPagingResultMap(StringBuffer sql, int page, int size, Sort sort);
}