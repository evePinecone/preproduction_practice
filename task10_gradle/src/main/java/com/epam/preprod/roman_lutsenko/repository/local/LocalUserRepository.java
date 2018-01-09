package com.epam.preprod.roman_lutsenko.repository.local;

import com.epam.preprod.roman_lutsenko.repository.UserRepository;
import com.epam.preprod.roman_lutsenko.entities.User;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * LocalUserRepository with primary key for registration is phone number.
 */
public class LocalUserRepository implements UserRepository {

    private Map<String, User> map;

    public LocalUserRepository(Map<String, User> map) {
        this.map = Collections.synchronizedMap(map);
    }

    @Override
    public void add(User user) {
        map.put(user.getPhone(), user);
    }

    @Override
    public Map<String, User> getAllUsers() {
        return Collections.synchronizedMap(new HashMap<String, User>(map));
    }

    @Override
    public Object remove(String phone) {
        return map.remove(phone);
    }

    @Override
    public User getById(String phone) {
        return map.get(phone);
    }

}
