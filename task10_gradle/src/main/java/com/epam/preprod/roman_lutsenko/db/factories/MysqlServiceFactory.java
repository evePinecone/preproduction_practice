package com.epam.preprod.roman_lutsenko.db.factories;

import com.epam.preprod.roman_lutsenko.db.ServiceFactory;
import com.epam.preprod.roman_lutsenko.services.TestService;
import com.epam.preprod.roman_lutsenko.services.UserService;
import com.epam.preprod.roman_lutsenko.services.mySql.MySqlTestService;
import com.epam.preprod.roman_lutsenko.services.mySql.MySqlUserService;

/**
 * Implementation of DBServiceProvider for MySQL DataBase.
 *
 * @author inc_f
 */
public class MysqlServiceFactory implements ServiceFactory{

    private TestService testService;
    private UserService userService;

    public MysqlServiceFactory() {
        this.testService = new MySqlTestService();
        this.userService = new MySqlUserService();
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
