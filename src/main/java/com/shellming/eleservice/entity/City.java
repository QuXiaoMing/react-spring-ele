package com.shellming.eleservice.entity;

public class City {
    private Integer id;

    private String name;

    private String abbr;

    private String area_code;

    private Integer sort;

    private Double latitude;

    private Double longitude;

    private Boolean is_map;

    private Boolean pinyin;

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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Boolean getIs_map() {
        return is_map;
    }

    public void setIs_map(Boolean is_map) {
        this.is_map = is_map;
    }

    public Boolean getPinyin() {
        return pinyin;
    }

    public void setPinyin(Boolean pinyin) {
        this.pinyin = pinyin;
    }
}