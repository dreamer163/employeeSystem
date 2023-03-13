package com.situ.dao;

import com.situ.model.User;

public interface UserDAO {
    User findByUsername(String username);

    int update(User user);
}
