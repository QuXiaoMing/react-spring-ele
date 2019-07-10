package com.shellming.eleservice.service;

import com.shellming.eleservice.entity.Category;

import java.util.List;
import java.util.Map;

public interface ICategoryService {
    Category selectByPrimaryKey(Integer id);

    List list(Map map);

    List findByParentId(int parentId);

    int insert(Category category);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category category);
}
