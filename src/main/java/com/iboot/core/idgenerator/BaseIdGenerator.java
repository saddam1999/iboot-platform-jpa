package com.iboot.core.idgenerator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

/**
 * 使用Twitter Snowflake Id 演算產生Id
 */
public class BaseIdGenerator implements IdentifierGenerator{
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        SnowflakeIdWorker2nd idWorker = new SnowflakeIdWorker2nd(0, 0);
        return idWorker.nextId();
    }
}
