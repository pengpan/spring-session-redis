package com.github.pengpan.service;

import com.github.pengpan.entity.User;

import java.util.List;

public interface UserService {

    List<User> find();

    User findByName(String name);
}
