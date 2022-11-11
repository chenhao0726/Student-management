package com.chen.service;

import com.chen.domain.User;

public interface IUserService {

    User selectByName(String username);
}
