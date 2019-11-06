package com.shellming.eleservice.service;

import com.shellming.eleservice.entity.User;

import java.util.List;
import java.util.Map;

public interface IUserService {
    List<User> list(Map map);
    int create(User map);

    User getUserById(String id);

    User getUserByUserName(String userName);

    int updateByPrimaryKeySelective(User user);

    int deleteByPrimaryKey(String id);
}
