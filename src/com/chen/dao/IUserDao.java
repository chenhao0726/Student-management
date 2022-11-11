package com.chen.dao;

import com.chen.domain.Grade;
import com.chen.domain.User;

public interface IUserDao {

    User selectByName(String username);

}
