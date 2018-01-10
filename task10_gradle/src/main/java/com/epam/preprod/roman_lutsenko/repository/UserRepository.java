package com.epam.preprod.roman_lutsenko.repository;

import com.epam.preprod.roman_lutsenko.entity.User;

import java.util.Map;

public interface UserRepository {

    /**
     * Add new user with unique phone number.
     *
     * @param user User to add to the base.
     */
    boolean add(User user);

    /**
     * Removes user from container with such phone.
     *
     * @param phone Phone of removing user.
     * @return Result of operation. <b>true</b> if user removed successful, <b>false</b> if no such user.
     */
    boolean remove(String phone);

    /**
     * Returns User by its telephone in database.
     * If no user with such phone in impl than returns <b>null</b> element.
     *
     * @param phone unique index of user in container.
     * @return User with such phone, or <b>null</b> if user with such number didn't find.
     */
    User getById(String phone);

    /**
     * Returns map of user from container.
     *
     * @return Map with all users;
     */
    Map<String, User> getAllUsers();


}
