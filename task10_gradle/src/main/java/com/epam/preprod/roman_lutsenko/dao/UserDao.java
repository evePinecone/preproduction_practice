package com.epam.preprod.roman_lutsenko.dao;

import com.epam.preprod.roman_lutsenko.entities.User;
import com.epam.preprod.roman_lutsenko.exceptions.UserDuplicateException;

import java.util.Map;

public interface UserDao {

    /**
     * Add new user with unique phone number.
     *
     * @param user User to add to the base.
     * @throws UserDuplicateException if this user contains in our system.
     */
    void add(User user);

    /**
     * Returns User by his telephone in database.
     * If no user with such phone in impl than returns <b>null</b> element.
     *
     * @param phone unique index of user in container.
     * @return User with such phone, or <b>null</b> if user with such number didn't find.
     */
    User get(String phone);

    /**
     * Returns map of user from container.
     *
     * @return Map with all users;
     */
    Map<String, User> getAllUsers();

    /**
     * Removes user from container with such phone.
     *
     * @param phone Phone of removing user.
     * @return Result of operation. <b>object</b> if user removed succesfull, <b>null</b> if no such user.
     */
    Object remove(String phone);
}
