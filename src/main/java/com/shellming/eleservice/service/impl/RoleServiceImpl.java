package com.shellming.eleservice.service.impl;

import com.shellming.eleservice.entity.Role;
import com.shellming.eleservice.mapper.RoleMapper;
import com.shellming.eleservice.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> list(Map map) {
        return roleMapper.list(map);
    }

    @Override
    public int insert(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return roleMapper.deleteByPrimaryKey(id);
    }
}
