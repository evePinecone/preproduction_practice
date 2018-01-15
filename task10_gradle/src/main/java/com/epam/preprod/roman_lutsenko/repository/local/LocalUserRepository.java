package com.epam.preprod.roman_lutsenko.repository.local;

import com.epam.preprod.roman_lutsenko.entity.User;
import com.epam.preprod.roman_lutsenko.repository.UserRepository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * LocalUserRepository with primary key for registration is phone number.
 */
public class LocalUserRepository implements UserRepository {

    private Map<String, User> map;

    public LocalUserRepository(Map<String, User> map) {
        this.map = Collections.synchronizedMap(map);
    }

    @Override
    public boolean add(User user) {
        map.put(user.getPhone(), user);
        return true;
    }

    @Override
    public Map<String, User> getAllUsers() {
        return Collections.synchronizedMap(new HashMap<String, User>(map));
    }

    @Override
    public boolean remove(String phone) {
        return Objects.nonNull(map.remove(phone));
    }

    @Override
    public User getById(String phone) {
        return map.get(phone);
    }

}
