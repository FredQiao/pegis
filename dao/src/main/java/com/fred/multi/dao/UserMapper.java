package com.fred.multi.dao;

import com.fred.multi.domain.User;

import java.util.List;

public interface UserMapper {

    List<User> listUsers();

    User findByUserName(String username);
}
