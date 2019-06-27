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
    public int insert(City city) {
        return cityMapper.insert(city);
    }

    @Override
    public City selectByPrimaryKey(Integer id) {
        return cityMapper.selectByPrimaryKey(id);
    }

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
                for (Object data : JSONArray.fromObject(value)) {
                    try {
                        JSONObject obj = (JSONObject) data;
                        City city = new City((Integer) obj.get("id"),
                                (String) obj.get("name"),
                                (String) obj.get("abbr"),
                                key,
                                (String) obj.get("area_code"),
                                (Integer) obj.get("sort"),
                                (Double) obj.get("latitude"),
                                (Double) obj.get("longitude"),
                                (boolean) obj.get("is_map"),
                                (String) obj.get("pinyin")
                        );
                        log.info("city: {}", city);
                        int ret = cityMapper.insert(city);
                        if (ret > 0) {
                            log.info("插入成功");
                            count++;
                        }
                    } catch (Exception e) {
                        log.error("插入失败:{}", data);
                        log.error(e.toString());
                    }
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
