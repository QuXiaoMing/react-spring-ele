package com.shellming.eleservice.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class City {
    private Integer id;

    private String name;

    private String abbr;

    private String key;

    private String area_code;

    private Integer sort;

    private String latitude;

    private String longitude;

    private Boolean is_map;

    private String pinyin;

    public City(Integer id, String name, String abbr, String key, String area_code, Integer sort, String latitude, String longitude, Boolean is_map, String pinyin) {
        this.id = id;
        this.name = name;
        this.abbr = abbr;
        this.key = key;
        this.area_code = area_code;
        this.sort = sort;
        this.latitude = latitude;
        this.longitude = longitude;
        this.is_map = is_map;
        this.pinyin = pinyin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr == null ? null : abbr.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code == null ? null : area_code.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public Boolean getIs_map() {
        return is_map;
    }

    public void setIs_map(Boolean is_map) {
        this.is_map = is_map;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin == null ? null : pinyin.trim();
    }
}