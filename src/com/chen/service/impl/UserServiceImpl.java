package com.chen.service.impl;

import com.chen.dao.IUserDao;
import com.chen.dao.impl.UserDaoImpl;
import com.chen.domain.User;
import com.chen.service.IUserService;

public class UserServiceImpl implements IUserService {
    private IUserDao dao = new UserDaoImpl();

    @Override
    public User selectByName(String username) {
        return dao.selectByName(username);
    }
}
