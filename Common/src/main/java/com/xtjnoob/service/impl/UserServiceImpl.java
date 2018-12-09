package com.xtjnoob.service.impl;

import com.xtjnoob.dao.UserDao;
import com.xtjnoob.entity.User;
import com.xtjnoob.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User Login(String account, String password) {
        User user = userDao.getUserByAccount(account);
        if (user == null) {
            return null;
        }
        if (user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }
}
