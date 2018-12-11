package com.xtjnoob.service;

import com.xtjnoob.entity.User;

public interface UserService {
    User login(String account, String password);
}
