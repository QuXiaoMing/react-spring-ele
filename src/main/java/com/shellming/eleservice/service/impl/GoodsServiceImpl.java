package com.shellming.eleservice.service.impl;

import com.shellming.eleservice.entity.Goods;
import com.shellming.eleservice.mapper.GoodsMapper;
import com.shellming.eleservice.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List list(Map map) {
        return goodsMapper.list(map);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return goodsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Goods record) {
        return goodsMapper.insert(record);
    }

    @Override
    public int insertSelective(Goods record) {
        return goodsMapper.insertSelective(record);
    }

    @Override
    public Goods selectByPrimaryKey(Integer id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Goods record) {
        return goodsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Goods record) {
        return goodsMapper.updateByPrimaryKey(record);
    }
}
