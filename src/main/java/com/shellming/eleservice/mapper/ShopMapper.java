package com.shellming.eleservice.mapper;

import com.shellming.eleservice.entity.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShopMapper {
    int deleteByPrimaryKey(String id);

    List list(Map map);

    List search(Map map);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
}