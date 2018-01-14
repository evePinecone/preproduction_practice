package com.epam.preprod.roman_lutsenko.db;

import com.epam.preprod.roman_lutsenko.service.UserService;

/**
 * Interface for service layer. Stack of services must be implemented.
 */
public interface ServiceFactory {

    UserService getUserService();
}
