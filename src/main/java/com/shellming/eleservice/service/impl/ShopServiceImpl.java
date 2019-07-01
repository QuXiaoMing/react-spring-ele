package com.shellming.eleservice.service.impl;

import com.shellming.eleservice.entity.Shop;
import com.shellming.eleservice.mapper.ShopMapper;
import com.shellming.eleservice.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShopServiceImpl implements IShopService {
    @Autowired
    private ShopMapper shopMapper;

    @Override
    public int create(Shop shop) {
        return shopMapper.insert(shop);
    }

    @Override
    public List list(Map map) {
        return shopMapper.list(map);
    }

    @Override
    public List search(Map map) {
        return shopMapper.search(map);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return shopMapper.deleteByPrimaryKey(id);
    }
}
