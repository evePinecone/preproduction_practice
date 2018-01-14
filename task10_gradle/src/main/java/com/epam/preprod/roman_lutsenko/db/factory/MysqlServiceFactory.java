package com.epam.preprod.roman_lutsenko.db.factory;

import com.epam.preprod.roman_lutsenko.db.ServiceFactory;
import com.epam.preprod.roman_lutsenko.db.util.TransactionManager;
import com.epam.preprod.roman_lutsenko.service.UserService;
import com.epam.preprod.roman_lutsenko.service.mySql.MySqlUserService;

/**
 * Implementation of DBServiceProvider for MySQL DataBase.
 *
 * @author inc_f
 */
public class MysqlServiceFactory implements ServiceFactory {

    private UserService userService;

    public MysqlServiceFactory(TransactionManager transactionManager) {
        this.userService = new MySqlUserService(transactionManager);
    }

    @Override
    public UserService getUserService() {
        return userService;
    }


}
