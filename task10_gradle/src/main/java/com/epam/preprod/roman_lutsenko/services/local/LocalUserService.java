package com.epam.preprod.roman_lutsenko.services.local;

import com.epam.preprod.roman_lutsenko.dao.UserDao;
import com.epam.preprod.roman_lutsenko.entities.User;
import com.epam.preprod.roman_lutsenko.exception.NoSuchUserException;
import com.epam.preprod.roman_lutsenko.exception.UserDuplicateException;
import com.epam.preprod.roman_lutsenko.services.UserService;

import java.util.Map;
import java.util.Objects;

public class LocalUserService implements UserService {

    private UserDao userDao;

    public LocalUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public synchronized void add(User user) throws UserDuplicateException {
        if (Objects.isNull(userDao.get(user.getPhone()))) {
            userDao.add(user);
        } else {
            throw new UserDuplicateException();
        }
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
        Object object = userDao.remove(phone);
        if(Objects.isNull(object)) {
            throw new NoSuchUserException();
        }
        return true;
    }

    @Override
    public boolean contains(String phone) {
        User user = userDao.get(phone);
        return Objects.nonNull(user);
    }
}
