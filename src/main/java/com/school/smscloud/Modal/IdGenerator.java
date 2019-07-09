package com.school.smscloud.Modal;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class IdGenerator extends SequenceStyleGenerator {
    public static final String prefix = "EMP";
    public static final String prefixDefault = "";
    private String EMP;

    public static final String numberParam = "numberFormat";
    public static final String numberparamDefault = "%d";

    private String numberFormat;

    @Override
    public Serializable generate(SharedSessionContractImplementor session,Object object) throws HibernateException{
        return EMP + String.format(numberFormat,super.generate(session,object));
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        super.configure(LongType.INSTANCE, params, serviceRegistry);
        EMP = ConfigurationHelper.getString(prefix,
                params, prefixDefault);
        numberFormat = ConfigurationHelper.getString(numberParam,
                params, numberparamDefault);
    }
}
