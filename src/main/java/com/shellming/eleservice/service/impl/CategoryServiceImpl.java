package com.shellming.eleservice.service.impl;

import com.shellming.eleservice.entity.Category;
import com.shellming.eleservice.mapper.CategoryMapper;
import com.shellming.eleservice.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List list(Map map) {
        return categoryMapper.list(map);
    }

    @Override
    public int insert(Category category) {
        return categoryMapper.insert(category);
    }
}
