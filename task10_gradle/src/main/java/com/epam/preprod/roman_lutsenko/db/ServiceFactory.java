package com.epam.preprod.roman_lutsenko.db;

import com.epam.preprod.roman_lutsenko.service.TestService;
import com.epam.preprod.roman_lutsenko.service.UserService;

public interface ServiceFactory {

    TestService getTestService();

    UserService getUserService();
}
