package com.epam.preprod.roman_lutsenko.constant.provider;


import com.epam.preprod.roman_lutsenko.constant.Fields;
import com.epam.preprod.roman_lutsenko.constant.Messages;
import com.epam.preprod.roman_lutsenko.db.ServiceFactory;
import com.epam.preprod.roman_lutsenko.db.factory.MysqlServiceFactory;
import com.epam.preprod.roman_lutsenko.exception.DBException;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 * Data Access Object pattern implementation main class.
 */
public class DBServiceProvider {

    /**
     * Apache Log4j Logger
     */
    private static final Logger LOG = Logger.getLogger(DBServiceProvider.class);
    /**
     * Full Class Name of a certain DBServiceProvider implementation.
     */
    private String serviceFactoryName;
    private Map<String, ServiceFactory> map;

    public DBServiceProvider(){
        map = new HashMap<>();
        //put service factory
        map.put(Fields.INIT_LISTENER_MYSQL, new MysqlServiceFactory());
    }


    /**
     * Sets Full Class Name of a current implementation of the DBServiceProvider.
     *
     * @param serviceFactoryName Full Class Name of a current implementation of the DBServiceProvider
     *                      to set.
     */
    public void setServiceFactoryName(String serviceFactoryName) {
        this.serviceFactoryName = serviceFactoryName;
    }

    /**
     * Creates an instance of current DBServiceProvider implementation using its Full
     * Class Name. Should set serviceFactoryName before.
     *
     * @return Instance of a certain DBServiceProvider implementation.
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
