package com.github.pengpan.service.impl;

import com.github.pengpan.dao.UserMapper;
import com.github.pengpan.entity.User;
import com.github.pengpan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> find() {
        return userMapper.find();
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }
}
