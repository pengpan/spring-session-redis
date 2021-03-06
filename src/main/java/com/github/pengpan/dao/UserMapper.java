package com.github.pengpan.dao;

import com.github.pengpan.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> find();

    User findByName(String name);

}