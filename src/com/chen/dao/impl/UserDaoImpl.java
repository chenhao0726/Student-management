package com.chen.dao.impl;

import com.chen.dao.IUserDao;
import com.chen.domain.User;
import com.chen.util.JdbcUtil;
import org.apache.ibatis.session.SqlSession;

public class UserDaoImpl implements IUserDao {
    private static final String MYSQL = "com.chen.mapper.UserMapper.";

    @Override
    public User selectByName(String username) {
        SqlSession session = JdbcUtil.getSession();
        User user = session.selectOne(UserDaoImpl.MYSQL + "selectByName", username);
        session.close();
        return user;
    }
}
