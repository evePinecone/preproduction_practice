package com.epam.preprod.roman_lutsenko.dao;

import com.epam.preprod.roman_lutsenko.db.DAOFactory;
import com.epam.preprod.roman_lutsenko.exceptions.DBException;

/**
 * Implementation of DAOFactory for MySQL DataBase.
 *
 * @author inc_f
 */
public class MysqlDAOFactory extends DAOFactory {

    public MysqlDAOFactory() throws DBException {
        // No operations
    }

//	@Override
//	public UserDao getUserDAO() throws DBException {
//		return new LocalUserDao();
//	}
//

}
