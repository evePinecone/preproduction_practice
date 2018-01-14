package com.epam.preprod.roman_lutsenko.db.util;


import com.epam.preprod.roman_lutsenko.constant.Messages;
import com.epam.preprod.roman_lutsenko.db.IExecutable;
import com.epam.preprod.roman_lutsenko.exception.DBException;
import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Utility class for common database operations.
 *
 * @author inc_f
 */
public class TransactionManager {

    /**
     * JNDI connections pool data source.
     */
    private static DataSource ds;

    /**
     * Apache Log4j logger
     */
    private static final Logger logger = Logger.getLogger(TransactionManager.class);

    public <T> T execute(IExecutable<T> iExecutable) {
        Connection connection = null;
        T res = null;
        try {
            connection = getConnection();
            ConnectionHolder.setConnection(connection);
            res = (T) iExecutable.executeTransaction();
            connection.commit();
        } catch (SQLException | DBException e) {
            rollBack(connection);
        } finally {
            close(connection);
        }
        return res;
    }

    /**
     * Creates (or takes from a pool) Data Base connection.
     *
     * @return Connection object.
     * @throws DBException
     */
    public static Connection getConnection() throws DBException {
        initDatasource();
        Connection connection = null;
        try {
            connection = ds.getConnection();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
        } catch (SQLException e) {
            logger.error(Messages.ERR_CANNOT_OBTAIN_CONNECTION);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_CONNECTION, e);
        }
        return connection;
    }

    /**
     * Initializes a data sourc e object.
     *
     * @throws DBException
     */
    private static void initDatasource() throws DBException {
        if (ds == null) {
            try {
                Context initialContext = new InitialContext();
                Context shopContext = (Context) initialContext.lookup("java:/comp/env");
                ds = (DataSource) shopContext.lookup("jdbc/task10_gradle");
                logger.trace(Messages.SUCCESS_DATA_SOURCE_OBTAINED + ds);
            } catch (NamingException e) {
                logger.error(Messages.ERR_CANNOT_OBTAIN_DATA_SOURCE);
                throw new DBException(Messages.ERR_CANNOT_OBTAIN_DATA_SOURCE, e);
            }
        }
    }

    /**
     * Closes a connection.
     *
     * @param con to be closed.
     */
    public static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
                logger.trace(Messages.SUCCESS_CONNECTION_CLOSED);
            } catch (SQLException e) {
                logger.error(Messages.ERR_CANNOT_CLOSE_CONNECTION, e);
            }
        }
    }

    /**
     * Closes a Statement object.
     *
     * @param stmt Statement object to be closed.
     */
    public static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
                logger.trace(Messages.SUCCESS_STATEMENT_CLOSED);
            } catch (SQLException e) {
                logger.error(Messages.ERR_CANNOT_CLOSE_STATEMENT, e);
            }
        }
    }

    /**
     * Closes a ResultSet object.
     *
     * @param rs ResultSet object to be closed.
     */
    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
                logger.trace(Messages.SUCCESS_RESULTSET_CLOSED);
            } catch (SQLException e) {
                logger.error(Messages.ERR_CANNOT_CLOSE_RESULTSET, e);
            }
        }
    }

    /**
     * Closes multiple resources.
     *
     * @param con  to be closed.
     * @param stmt Statement object to be closed.
     * @param rs   ResultSet object to be closed.
     */
    public static void close(Connection con, Statement stmt, ResultSet rs) {
        close(con);
        close(stmt);
        close(rs);
    }

    /**
     * Rolling back the Connection object.
     *
     * @param con Connection object.
     */
    public static void rollBack(Connection con) {
        if (con != null) {
            try {
                con.rollback();
                logger.trace(Messages.SUCCESS_CONNECTION_ROLLED_BACK);
            } catch (SQLException e) {
                logger.error(Messages.ERR_CANNOT_ROLL_BACK_CONNECTION, e);
            }
        }
    }
}
