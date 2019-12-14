package com.iboot.base.idgenerator;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Properties;

public class CustomizeIdGenerator implements IdentifierGenerator, Configurable {

  public static final String PREFIX_PARAMETER = "prefix";
  public static final String PREFIX_DEFAULT = "";
  private String prefix;

  public static final String SEPARATOR_PARAMETER = "separator";
  public static final String SEPARATOR_DEFAULT = "";
  private String separator;


  public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
  public static final String NUMBER_FORMAT_DEFAULT = "%05d";
  private String numberFormat;

  public static final String DATE_FORMAT_PARAMETER = "dateFormat";
  public static final String DATE_FORMAT_DEFAULT = "YYYYMMDD";
  private String dateFormat;

  public static final String MESSAGE_TEMPLATE = "messageTemplate";
  public static final String MESSAGE_TEMPLATE_DEFAULT = "";
  private String messageTemplate;


  @Override
  public void configure(Type type, Properties properties, ServiceRegistry serviceRegistry) throws MappingException {
    prefix = ConfigurationHelper.getString(PREFIX_PARAMETER, properties, PREFIX_DEFAULT);
    numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, properties, NUMBER_FORMAT_DEFAULT);
    dateFormat = ConfigurationHelper.getString(DATE_FORMAT_PARAMETER, properties, DATE_FORMAT_DEFAULT);
    separator = ConfigurationHelper.getString(SEPARATOR_PARAMETER, properties, SEPARATOR_DEFAULT);

    //this.format = dateFormat+dateNumberSeparator+numberFormat;
  }

  @Override
  public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {

    String msg = messageTemplate;

    String[] array = new String[]{"A","B","C","D","E","F","G","H","I",};
    String value = MessageFormat.format(messageTemplate, array);


    String query = String.format("select %s from %s", session.getEntityPersister(obj.getClass().getName(), obj)
            .getIdentifierPropertyName(), obj.getClass().getSimpleName());
    System.out.println("query: "+query);
    //Stream ids = session.createQuery(query).stream();

//    Long max = ids.map(o -> o.replace(valuePrefix + "-", ""))
//        .mapToLong(Long::parseLong)
//        .max()
//        .orElse(0L);
    return prefix + "-" ;//+ (max + 1);
    //return valuePrefix + String.format(numberFormat, super.generate(session, object));
//    return valuePrefix + String.format(numberFormat, super.generate(session, object));
  }
}