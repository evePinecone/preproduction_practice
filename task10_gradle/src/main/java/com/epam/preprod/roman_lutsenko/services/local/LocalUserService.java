package com.epam.preprod.roman_lutsenko.services.local;

import com.epam.preprod.roman_lutsenko.repository.UserRepository;
import com.epam.preprod.roman_lutsenko.entities.User;
import com.epam.preprod.roman_lutsenko.exception.NoSuchUserException;
import com.epam.preprod.roman_lutsenko.exception.UserDuplicateException;
import com.epam.preprod.roman_lutsenko.services.UserService;

import java.util.Map;
import java.util.Objects;

public class LocalUserService implements UserService {

    private UserRepository userRepository;

    public LocalUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public synchronized void add(User user) throws UserDuplicateException {
        if (Objects.isNull(userRepository.getById(user.getPhone()))) {
            userRepository.add(user);
        } else {
            throw new UserDuplicateException();
        }
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
        Object object = userRepository.remove(phone);
        if(Objects.isNull(object)) {
            throw new NoSuchUserException();
        }
        return true;
    }

    @Override
    public boolean contains(String phone) {
        User user = userRepository.getById(phone);
        return Objects.nonNull(user);
    }
}
