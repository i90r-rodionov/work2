package org.homework.igorr.domain.generator;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

@Slf4j
public class SnowFlakeMock implements IdentifierGenerator, Configurable {
    @Override
    public void configure(Type type, Properties properties, ServiceRegistry serviceRegistry) throws MappingException {
        // nothing
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o)
            throws HibernateException {
        Long id = (new Date()).getTime() * 1000 + generateRandom(1000L);
        LOG.debug("Generated id = {}", id);
        return id;
    }

    private long generateRandom(long rightLimit) {
        long leftLimit = 1L;
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }
}
