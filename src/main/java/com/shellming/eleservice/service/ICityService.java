package com.shellming.eleservice.service;

import com.shellming.eleservice.entity.City;

public interface ICityService {
    int insert(City city);

    City selectByPrimaryKey(Integer id);

    int loadCityData();
}
