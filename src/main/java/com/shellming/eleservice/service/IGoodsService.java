package com.shellming.eleservice.service;

import com.shellming.eleservice.entity.Goods;

import java.util.List;
import java.util.Map;

public interface IGoodsService {
    List list(Map map);

    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}
