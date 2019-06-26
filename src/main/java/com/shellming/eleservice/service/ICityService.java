package com.shellming.eleservice.service;

import com.shellming.eleservice.entity.City;

public interface ICityService {
    int insert(City city);

    int loadCityData();
}
