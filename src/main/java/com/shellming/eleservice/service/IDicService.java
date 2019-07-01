package com.shellming.eleservice.service;

import com.shellming.eleservice.entity.Dic;

import java.util.List;
import java.util.Map;

public interface IDicService {
    List list (Map map);

    int insert(Dic dic);

    int deleteByPrimaryKey(String id);
}
