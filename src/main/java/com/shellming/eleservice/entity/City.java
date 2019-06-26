package com.shellming.eleservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class City {
    @Id
    private Integer id;

    private String name;

    private String abbr;

    private String key;

    private String area_code;

    private Integer sort;

    private Double latitude;

    private Double longitude;

    private Boolean is_map;

    private Boolean pinyin;

    public City(Integer id, String name, String abbr, String key, String area_code, Integer sort, Double latitude, Double longitude, Boolean is_map, Boolean pinyin) {
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
}