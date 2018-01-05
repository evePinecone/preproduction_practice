package com.epam.preprod.roman_lutsenko.db;


import javax.sql.DataSource;

import com.epam.preprod.roman_lutsenko.constants.Messages;
import com.epam.preprod.roman_lutsenko.exceptions.DBException;
import org.apache.log4j.Logger;


/**
 * Data Access Object pattern implementation main class.
 *
 * @author inc_f
 */
public abstract class DAOFactory {

    /**
     * Apache Log4j Logger
     */
    private static final Logger LOG = Logger.getLogger(DAOFactory.class);

    /**
     * JNDI connections pool data source.
     */
    protected DataSource ds;

    /**
     * Holder for an instance of the DAOFactory.
     */
    protected static DAOFactory instance;

    /**
     * Full Class Name of a certain DAOFactory implementation.
     */
    private static String daoFactoryFCN;

    /**
     * Sets Full Class Name of a current implementation of the DAOFactory.
     *
     * @param daoFactoryFCN Full Class Name of a current implementation of the DAOFactory
     *                      to set.
     */
    public static void setDaoFactoryFCN(String daoFactoryFCN) {
        instance = null;
        DAOFactory.daoFactoryFCN = daoFactoryFCN;
    }

    /**
     * Creates an instance of current DAOFactory implementation using its Full
     * Class Name. Should set daoFactoryFCN before.
     *
     * @return Instance of a certain DAOFactory implementation.
     * @throws DBException
     */
    public static synchronized DAOFactory getInstance() throws DBException {
        if (instance == null) {
            Class<?> clazz = null;
            try {
                clazz = Class.forName(DAOFactory.daoFactoryFCN);
                instance = (DAOFactory) clazz.newInstance();
                LOG.debug(Messages.SUCCESS_DAO_FACTORY_INSTANCE_OBTAINED + instance);
            } catch (Exception e) {
                LOG.error(Messages.ERR_CANNOT_INSTANTIATE_DAO_FACTORY);
                throw new DBException(Messages.ERR_CANNOT_INSTANTIATE_DAO_FACTORY, e);
            }
        }
        return instance;
    }

    protected DAOFactory() throws DBException {
        // No operations
    }
//
//	/**
//	 * Creates UserDAO object of a certain implementation of DAOFactory.
//	 *
//	 * @return UserDao object.
//	 * @throws DBException
//	 */
//	public abstract UserDAO getUserDAO() throws DBException;
//
}
