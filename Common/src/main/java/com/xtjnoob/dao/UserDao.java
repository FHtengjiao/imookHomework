package com.xtjnoob.dao;

import com.xtjnoob.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User getUserByAccount(String account);
}
