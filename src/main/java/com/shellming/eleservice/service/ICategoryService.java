package com.shellming.eleservice.service;

import com.shellming.eleservice.entity.Category;

import java.util.List;
import java.util.Map;

public interface ICategoryService {
    List list(Map map);

    int insert(Category category);
}
