package com.epam.preprod.roman_lutsenko.services.mySql;

import com.epam.preprod.roman_lutsenko.dao.UserDao;
import com.epam.preprod.roman_lutsenko.dao.local.LocalUserDao;
import com.epam.preprod.roman_lutsenko.entities.User;
import com.epam.preprod.roman_lutsenko.exceptions.UserDuplicateException;
import com.epam.preprod.roman_lutsenko.services.UserService;

import java.util.Map;
import java.util.Objects;

public class MySqlUserService implements UserService{

    private UserDao userDao;

    public MySqlUserService() {
        userDao = new LocalUserDao();
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
        return Objects.nonNull(get(phone));
    }
}
