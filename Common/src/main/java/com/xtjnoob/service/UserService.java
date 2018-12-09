package com.xtjnoob.service;

import com.xtjnoob.entity.User;

public interface UserService {
    User Login(String account, String password);
}
