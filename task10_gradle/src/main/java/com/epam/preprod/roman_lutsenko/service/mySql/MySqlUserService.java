package com.epam.preprod.roman_lutsenko.service.mySql;

import com.epam.preprod.roman_lutsenko.entity.User;
import com.epam.preprod.roman_lutsenko.exception.UserDuplicateException;
import com.epam.preprod.roman_lutsenko.repository.UserRepository;
import com.epam.preprod.roman_lutsenko.repository.mySql.MySqlUserRepository;
import com.epam.preprod.roman_lutsenko.service.UserService;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.Objects;

public class MySqlUserService implements UserService {

    public static final Logger LOG = Logger.getLogger(MySqlUserService.class);

    private UserRepository userRepository;

    public MySqlUserService() {
        userRepository = new MySqlUserRepository();
    }

    @Override
    public void add(User user) throws UserDuplicateException {
        LOG.debug("add method service");
        //todo: log refactor, logic on exception
//        if(Objects.isNull(userRepository.getById(user.getPhone()))) {
//            throw new UserDuplicateException();
//        }
        userRepository.add(user);
    }

    @Override
    public User get(String phone) {
        return userRepository.getById(phone);
    }

    @Override
    public Map<String, User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public boolean remove(String phone) {
        return false;
        //todo: implement remove service
    }

    @Override
    public boolean contains(String phone) {
        return Objects.nonNull(get(phone));
    }
}
