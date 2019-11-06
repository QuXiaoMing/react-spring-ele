package com.shellming.eleservice.service.impl;

import com.shellming.eleservice.entity.User;
import com.shellming.eleservice.mapper.UserMapper;
import com.shellming.eleservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list(Map map){
        List ret = userMapper.list(map);
        return ret;
    }

    @Override
    public int create(User map) {
        int ret = userMapper.insert(map);
        return ret;
    }

    @Override
    public User getUserById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }


    @Override
    public User getUserByUserName(String userName) {
        return userMapper.selectByUserName(userName);
    }

    @Override
    public int updateByPrimaryKeySelective(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return  userMapper.deleteByPrimaryKey(id);
    }
}
