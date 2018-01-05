package com.epam.preprod.roman_lutsenko.constants;


import com.epam.preprod.roman_lutsenko.db.ServiceFactory;
import com.epam.preprod.roman_lutsenko.db.factories.MysqlServiceFactory;
import com.epam.preprod.roman_lutsenko.exceptions.DBException;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 * Data Access Object pattern implementation main class.
 */
public class DBServiceFactory {

    /**
     * Apache Log4j Logger
     */
    private static final Logger LOG = Logger.getLogger(DBServiceFactory.class);
    /**
     * Full Class Name of a certain DBServiceFactory implementation.
     */
    private String serviceFactoryName;
    private Map<String, ServiceFactory> map;

    public DBServiceFactory(){
        map = new HashMap<>();
        map.put(Fields.INIT_LISTENER_MYSQL, new MysqlServiceFactory());
    }


    /**
     * Sets Full Class Name of a current implementation of the DBServiceFactory.
     *
     * @param serviceFactoryName Full Class Name of a current implementation of the DBServiceFactory
     *                      to set.
     */
    public void setServiceFactoryName(String serviceFactoryName) {
        this.serviceFactoryName = serviceFactoryName;
    }

    /**
     * Creates an instance of current DBServiceFactory implementation using its Full
     * Class Name. Should set serviceFactoryName before.
     *
     * @return Instance of a certain DBServiceFactory implementation.
     * @throws DBException
     */
    public ServiceFactory getInstance() {
        ServiceFactory serviceFactory = map.get(serviceFactoryName);
        if(Objects.isNull(serviceFactory)) {
            LOG.error(Messages.ERR_CANNOT_INSTANTIATE_SERVICE_FACTORY);
            throw new DBException(Messages.ERR_CANNOT_INSTANTIATE_SERVICE_FACTORY);
        }
        return serviceFactory;
    }


}
