package com.shellming.eleservice.service.impl;

import com.shellming.eleservice.entity.Shop;
import com.shellming.eleservice.mapper.ShopMapper;
import com.shellming.eleservice.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements IShopService {
    @Autowired
    private ShopMapper shopMapper;

    @Override
    public int create(Shop shop) {
        return shopMapper.insert(shop);
    }
}
