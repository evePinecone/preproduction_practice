package com.epam.preprod.roman_lutsenko.db;

import com.epam.preprod.roman_lutsenko.services.TestService;
import com.epam.preprod.roman_lutsenko.services.UserService;

public interface ServiceFactory {

    TestService getTestService();

    UserService getUserService();
}
