package com.situ.service;

import com.situ.model.Employee;
import com.situ.model.User;

public interface UserService {

    User findByUsername(String username);
    boolean checkLogin(User user,String password);
    boolean update(User user);

}
