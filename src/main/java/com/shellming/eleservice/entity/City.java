package com.shellming.eleservice.entity;

public class City {
    private Integer id;

    private String name;

    private String abbr;

    private String name_key;

    private String area_code;

    private Integer sort;

    private Double latitude;

    private Double longitude;

    private Boolean is_map;

    private String pinyin;

    public City(Integer id, String name, String abbr, String name_key, String area_code, Integer sort, Double latitude, Double longitude, Boolean is_map, String pinyin) {
        this.id = id;
        this.name = name;
        this.abbr = abbr;
        this.name_key = name_key;
        this.area_code = area_code;
        this.sort = sort;
        this.latitude = latitude;
        this.longitude = longitude;
        this.is_map = is_map;
        this.pinyin = pinyin;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", abbr='" + abbr + '\'' +
                ", name_key='" + name_key + '\'' +
                ", area_code='" + area_code + '\'' +
                ", sort=" + sort +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", is_map=" + is_map +
                ", pinyin='" + pinyin + '\'' +
                '}';
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

    public String getName_key() {
        return name_key;
    }

    public void setName_key(String name_key) {
        this.name_key = name_key == null ? null : name_key.trim();
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

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin == null ? null : pinyin.trim();
    }
}