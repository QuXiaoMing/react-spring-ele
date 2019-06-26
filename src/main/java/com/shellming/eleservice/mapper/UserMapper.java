package com.shellming.eleservice.mapper;

import com.shellming.eleservice.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String user_id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String user_id);

    User selectByUserName(String user_name);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> list(Map map);
}