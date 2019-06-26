package com.shellming.eleservice.service.impl;

import com.shellming.eleservice.entity.City;
import com.shellming.eleservice.mapper.CityMapper;
import com.shellming.eleservice.service.ICityService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.sf.json.JSONObject;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
@Slf4j
public class CityServiceImpl implements ICityService {
    @Autowired
    private CityMapper cityMapper;

    @Override
    public int loadCityData() {
        log.info("加载城市JSON数据");
        int count = 0;
        JSONObject jsonObject = loadJsonData();
        if (jsonObject != null) {
            Iterator iterator = jsonObject.keys();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                String value = jsonObject.getString(key);
                log.info("key:" + key);
                log.info("value:{}", value);
                for (Object city : JSONArray.fromObject(value)) {
                    Map map = toMap(city);
                    Map data = toMap(map.get("properties"));
                }
            }
        }
        log.info("加载成功：{}条", count);
        return count;
    }

    private JSONObject loadJsonData() {
        try {
            File jsonFile = ResourceUtils.getFile("classpath:CitiesInitData.json");
            String json = FileUtils.readFileToString(jsonFile);
            return JSONObject.fromObject(json);
        } catch (Exception e) {
            log.error("解析JSON报错{}", e);
        }
        return null;
    }

    public static Map<String, String> toMap(Object o) {
        Map<String, String> map = new HashMap<String, String>();
        Field[] fields = o.getClass().getDeclaredFields();
        try {
            for (int i = 0; i < fields.length; i++) {
                String name = fields[i].getName();
                Field field = o.getClass().getDeclaredField(name);
                field.setAccessible(true);
                log.info("set:" + name + ":" + field);
                if (null != field) {
                    map.put(name, field.get(o).toString());
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return map;
    }
}
