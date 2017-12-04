package com.fred.multi.service;

import com.fred.multi.dao.UserMapper;
import com.fred.multi.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> listUsers(){
        return userMapper.listUsers();
    };
}
