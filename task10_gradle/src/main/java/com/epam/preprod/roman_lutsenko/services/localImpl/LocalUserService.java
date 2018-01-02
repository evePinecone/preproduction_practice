package com.epam.preprod.roman_lutsenko.services.localImpl;

import com.epam.preprod.roman_lutsenko.dao.UserDao;
import com.epam.preprod.roman_lutsenko.entities.User;
import com.epam.preprod.roman_lutsenko.exceptions.UserDuplicateException;
import com.epam.preprod.roman_lutsenko.services.UserService;

import java.util.Map;
import java.util.Objects;

public class LocalUserService implements UserService {

    private UserDao userDao;

    public LocalUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) throws UserDuplicateException {
        userDao.add(user);
    }

    @Override
    public User get(String phone) {
        return userDao.get(phone);
    }

    @Override
    public Map<String, User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public boolean remove(String phone) {
        return userDao.remove(phone);
    }

    @Override
    public boolean contains(String phone) {
        User user = userDao.get(phone);
        return Objects.nonNull(user);
    }
}
