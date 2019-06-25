package com.shellming.eleservice.service;

import com.shellming.eleservice.entity.Role;

import java.util.List;
import java.util.Map;

public interface IRoleService {
    List<Role> list(Map map);

    int insert(Role role);

    int deleteByPrimaryKey(String id);
}
