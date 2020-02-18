package com.iboot.admin.domain.idgenerator;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentityGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Properties;

public class UserNoIdGenerator extends IdentityGenerator implements Configurable {


  public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
  public static final String NUMBER_FORMAT_DEFAULT = "%06d";
  private String numberFormat;
  private String format;

  @Override
  public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
      String queryStr = "SELECT count(user_no) FROM tbuser";
      Query<BigInteger> query = session.createNativeQuery(queryStr);
      BigInteger id = query.getSingleResult();
      if (id != null) {
        return (Serializable) String.format(format, id);
      }
    return super.generate(session, obj);
  }

  @Override
  public void configure(Type type, Properties properties, ServiceRegistry serviceRegistry) throws MappingException {
    numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, properties, NUMBER_FORMAT_DEFAULT);
    this.format = numberFormat;
  }
}