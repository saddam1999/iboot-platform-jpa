package com.iboot.core.repository;

import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T,ID>
    implements BaseRepository<T,ID> {

  private final EntityManager entityManager;
  private Class<T> klass;

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
//    Query query = em.createNamedQuery(Employee.SALARY_RANGE_QUERY);
//    query.setParameter("min", 2000L);
//    query.setParameter("max", 4000L);
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
    return entityManager.createNativeQuery(sql,klass).getResultList();
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

}