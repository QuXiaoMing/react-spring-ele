package com.shellming.eleservice.service;

import com.shellming.eleservice.entity.City;

import java.util.List;
import java.util.Map;

public interface ICityService {
    int insert(City city);

    List list(Map map);

    City selectByPrimaryKey(Integer id);

    int loadCityData();
}
