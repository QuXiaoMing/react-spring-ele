package com.shellming.eleservice.mapper;

import com.shellming.eleservice.entity.Dic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DicMapper {
    List list(Map map);

    int deleteByPrimaryKey(String id);

    int insert(Dic record);

    int insertSelective(Dic record);

    Dic selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Dic record);

    int updateByPrimaryKey(Dic record);
}