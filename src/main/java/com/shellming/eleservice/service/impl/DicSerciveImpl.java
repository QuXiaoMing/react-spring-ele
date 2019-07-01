package com.shellming.eleservice.service.impl;

import com.shellming.eleservice.entity.Dic;
import com.shellming.eleservice.mapper.DicMapper;
import com.shellming.eleservice.service.IDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DicSerciveImpl implements IDicService {

    @Autowired private DicMapper dicMapper;

    @Override
    public List list(Map map) {
        return dicMapper.list(map);
    };

    @Override
    public int insert(Dic dic) {
        return dicMapper.insert(dic);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return dicMapper.deleteByPrimaryKey(id);
    }
}
