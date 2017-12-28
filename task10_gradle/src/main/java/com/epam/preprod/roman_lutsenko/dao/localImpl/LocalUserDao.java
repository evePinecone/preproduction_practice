package com.epam.preprod.roman_lutsenko.dao.localImpl;

import com.epam.preprod.roman_lutsenko.dao.UserDao;
import com.epam.preprod.roman_lutsenko.entities.User;
import com.epam.preprod.roman_lutsenko.exceptions.UserDuplicateException;

import java.util.HashMap;
import java.util.Map;

/**
 * LocalUserDao with primary key for registration is phone number.
 */
public class LocalUserDao implements UserDao {

    private Map<Integer, User> map;

    public LocalUserDao() {
        map = new HashMap<>();
        fill();
    }

    @Override
    public void add(User user) throws UserDuplicateException {
        if(!map.containsKey(user.getPhone())) {
            map.put(user.getPhone(), user);
        } else {
            throw new UserDuplicateException();
        }
    }

    @Override
    public Map<Integer, User> getAllUsers(){
        return new HashMap<Integer, User>(map);
    }

    @Override
    public boolean remove(Integer phone) {
       //TODO: crate remove logic for DAO impl.
        return false;
    }
    @Override
    public User get(Integer phone) {
        return map.get(phone);
    }

    /**
     * Cheating method with constant users.
     */
    private void fill() {
        for (int index = 0; index < 10; index++) {
            User user = new User();
            user.setId(index);
            user.setName("name" + index);
            user.setEmail("email" + index);
            user.setPhone(10000000 + index);
            user.setPassword("password" + index);
            map.put(user.getPhone(), user);
        }
    }
}
