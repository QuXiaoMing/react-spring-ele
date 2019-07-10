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
    public Category selectByPrimaryKey(Integer id) {
        return  categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List list(Map map) {
        return categoryMapper.list(map);
    }

    @Override
    public int insert(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public List findByParentId(int parentId) {
        return categoryMapper.findByParentId(parentId);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Category category) {
        return categoryMapper.updateByPrimaryKeySelective(category);
    }
}
