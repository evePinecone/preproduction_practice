package com.epam.preprod.roman_lutsenko.db.factory;

import com.epam.preprod.roman_lutsenko.db.ServiceFactory;
import com.epam.preprod.roman_lutsenko.db.util.TransactionManager;
import com.epam.preprod.roman_lutsenko.service.TestService;
import com.epam.preprod.roman_lutsenko.service.UserService;
import com.epam.preprod.roman_lutsenko.service.mySql.MySqlTestService;
import com.epam.preprod.roman_lutsenko.service.mySql.MySqlUserService;

/**
 * Implementation of DBServiceProvider for MySQL DataBase.
 *
 * @author inc_f
 */
public class MysqlServiceFactory implements ServiceFactory{

    private TestService testService;
    private UserService userService;

    public MysqlServiceFactory(TransactionManager transactionManager) {
        this.testService = new MySqlTestService();
        this.userService = new MySqlUserService(transactionManager);
    }

    @Override
    public TestService getTestService() {
        return testService;
    }

	@Override
	public UserService getUserService() {
		return userService;
	}


}
