package com.epam.preprod.roman_lutsenko.service.mySql;

import com.epam.preprod.roman_lutsenko.db.util.TransactionManager;
import com.epam.preprod.roman_lutsenko.entity.User;
import com.epam.preprod.roman_lutsenko.exception.UserDuplicateException;
import com.epam.preprod.roman_lutsenko.repository.UserRepository;
import com.epam.preprod.roman_lutsenko.repository.mySql.MySqlUserRepository;
import com.epam.preprod.roman_lutsenko.service.UserService;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.Objects;

import static com.epam.preprod.roman_lutsenko.constant.Messages.ADD_METHOD_SERVICE;
import static com.epam.preprod.roman_lutsenko.constant.Messages.CONTAINS_SERVICE;
import static com.epam.preprod.roman_lutsenko.constant.Messages.GET_ALL_USERS_SERVICE;
import static com.epam.preprod.roman_lutsenko.constant.Messages.GET_BY_ID_SERVICE;
import static com.epam.preprod.roman_lutsenko.constant.Messages.REMOVE_SERVICE;

public class MySqlUserService implements UserService {

    private static final Logger LOG = Logger.getLogger(MySqlUserService.class);

    private TransactionManager transactionManager;
    private UserRepository userRepository;

    public MySqlUserService(TransactionManager transactionManager) {
        //todo: change repository.
        this.userRepository = new MySqlUserRepository();
        this.transactionManager = transactionManager;
    }

    @Override
    public void add(User user) throws UserDuplicateException {
        LOG.debug(ADD_METHOD_SERVICE);
        Object resultAdd = transactionManager.execute(() -> {
            User userBuf = userRepository.getById(user.getPhone());
            if (Objects.isNull(userBuf)) {
                return userRepository.add(user);
            }
            return null;
        });
        if (Objects.isNull(resultAdd)) {
            throw new UserDuplicateException();
        }
    }

    @Override
    public User getById(String phone) {
        LOG.debug(GET_BY_ID_SERVICE);
        Object result = transactionManager.execute(() -> userRepository.getById(phone));
        return (User) result;
    }

    @Override
    public Map<String, User> getAllUsers() {
        LOG.debug(GET_ALL_USERS_SERVICE);
        return transactionManager.execute(() -> userRepository.getAllUsers());
    }

    @Override
    public boolean remove(String phone) {
        LOG.debug(REMOVE_SERVICE);
        return transactionManager.execute(() -> {
            return !Objects.isNull(userRepository.getById(phone)) && userRepository.remove(phone);
        });
    }

    @Override
    public boolean contains(String phone) {
        LOG.debug(CONTAINS_SERVICE);
        return transactionManager.execute(() -> Objects.nonNull(userRepository.getById(phone)));
    }
}
