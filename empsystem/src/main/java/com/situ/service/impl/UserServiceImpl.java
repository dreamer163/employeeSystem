package com.situ.service.impl;

import com.situ.dao.UserDAO;
import com.situ.dao.impl.UserDAOImpl;
import com.situ.model.User;
import com.situ.service.UserService;
import com.situ.util.BeanFactory;
import com.situ.util.Md5Utils;

public class UserServiceImpl implements UserService {
    private final UserDAO dao = BeanFactory.getBean(UserDAOImpl.class);

    @Override
    public User findByUsername(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public boolean checkLogin(User user, String password) {
        if(user == null) {
            return false;
        }
        if (password.equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(User user) {
        return dao.update(user)>0;
    }
}
