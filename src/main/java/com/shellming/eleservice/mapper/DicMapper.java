package com.shellming.eleservice.mapper;

import com.shellming.eleservice.entity.Dic;

public interface DicMapper {
    int deleteByPrimaryKey(String id);

    int insert(Dic record);

    int insertSelective(Dic record);

    Dic selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Dic record);

    int updateByPrimaryKey(Dic record);
}