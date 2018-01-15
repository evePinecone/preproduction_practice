package com.epam.preprod.roman_lutsenko.service.local;

import com.epam.preprod.roman_lutsenko.entity.User;
import com.epam.preprod.roman_lutsenko.exception.UserDuplicateException;
import com.epam.preprod.roman_lutsenko.repository.UserRepository;
import com.epam.preprod.roman_lutsenko.service.UserService;

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
    public User getById(String phone) {
        return userRepository.getById(phone);
    }

    @Override
    public Map<String, User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public boolean remove(String phone) {
        return userRepository.remove(phone);
    }

    @Override
    public boolean contains(String phone) {
        User user = userRepository.getById(phone);
        return Objects.nonNull(user);
    }
}
