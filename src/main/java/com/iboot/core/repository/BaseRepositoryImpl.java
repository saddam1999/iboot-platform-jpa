package com.iboot.core.repository;

import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T,ID>
    implements BaseRepository<T,ID> {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final EntityManager entityManager;
  private Class<T> klass;
  private enum ResultType { Map, List }

  BaseRepositoryImpl(JpaEntityInformation<T, ID> entityInformation,
                     EntityManager entityManager) {
    super(entityInformation, entityManager);
    this.entityManager = entityManager;
    this.klass = (Class<T>) entityInformation.getJavaType();
  }


  /**
   * SQL 查詢後回傳 Object List
   * @param sql
   * @return List<Object[]>
   */
  @Override
  public List<Object[]> queryForList(String sql) {
    return entityManager.createNativeQuery(sql).getResultList();
  }

  /**
   * SQL 查詢 物件, 找不到回傳null
   * @param sql
   * @return List<Map<String, Object>>
   */
  @Override
  public List<Map<String, Object>> queryForMap(String sql) {
    Query query =  entityManager.createNativeQuery(sql);
    query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    return query.getResultList();
  }

  /**
   * SQL 查詢 物件, 找不到回傳null
   * @param sql
   * @return Object
   */
  @Override
  public Object queryData(String sql) {
    List list = entityManager.createNativeQuery(sql).getResultList();
    if(list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

  /**
   * SQL 查詢後回傳 VO class
   * @param sql
   * @return T
   */
  @Override
  public T get(String sql) {
    List<T> list =  entityManager.createNativeQuery(sql,klass).getResultList();
    return list.get(0);
  }

  /**
   * SQL 查詢後回傳 VO class 集合
   * @param sql
   * @return
   */
  @Override
  public List<T> query(String sql) {
    Query query =  entityManager.createNativeQuery(sql);
    query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    return query.getResultList();
  }

  /**
   * 執行sql 語法回傳影響列數
   * @param sql
   * @return int
   */
  @Override
  public int execute(String sql) {
    return entityManager.createNativeQuery(sql).executeUpdate();
  }


  @Override
  public Class<T> getDataClass() {
    return klass;
  }



  /**
   * 獲取集合Map(帶分頁)
   */
  public Page<Map<String, Object>> queryPagingResultMap(StringBuffer sql, int page, int size, Sort sort){
    //查詢記錄條數
    String countSql = "select count(1) as cnt from (" + sql.toString() + ") temp ";
    //創建查詢對象
    Query countQuery = entityManager.createNativeQuery(countSql);
    //獲取總記錄數
    Object totalCount = countQuery.getSingleResult();
    //分頁查詢
    Query queryData = entityManager.createNativeQuery(sql.toString());
    queryData.setFirstResult(page * size);//當前頁總記錄數
    queryData.setMaxResults(size);//每頁數量數

    List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
    queryData.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

    try {
      data = queryData.getResultList();
    } catch(Exception e) {
      logger.info("執行獲取集合(帶分頁)出錯--{}", e.getMessage());
    }

    //設置分頁信息
    Page<Map<String, Object>> pageInfo = new PageImpl<Map<String, Object>>(data, PageRequest.of(page, size, sort), Long.valueOf(totalCount.toString()));
    return pageInfo;
  }

//  /**
//   * 獲取Entity集合(帶分頁)
//   */
//  public Page<T> queryPagingResultList(StringBuffer sql, int page, int size, Sort sort){
//
//    //查詢記錄條數
//    String countSql = "select count(1) as cnt from (" + sql.toString() + ") temp ";
//    //創建查詢對象
//    Query countQuery = entityManager.createNativeQuery(countSql);
//    //獲取總記錄數
//    Object totalCount = countQuery.getSingleResult();
//    //分頁查詢
//    Query queryData = entityManager.createNativeQuery(sql.toString());
//    queryData.setFirstResult(page * size);//當前頁總記錄數
//    queryData.setMaxResults(size);//每頁數量數
//
//    List<T> data = null;
//    queryData.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(klass));
//
//    try {
//      data = queryData.getResultList();
//    } catch(Exception e) {
//      logger.info("執行獲取集合(帶分頁)出錯--{}", e.getMessage());
//    }
//
//    //設置分頁信息
//    Page<T> pageInfo = new PageImpl<T>(data, PageRequest.of(page, size, sort), Long.valueOf(totalCount.toString()));
//    return pageInfo;
//  }


}