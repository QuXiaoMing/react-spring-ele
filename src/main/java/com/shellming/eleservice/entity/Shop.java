package com.shellming.eleservice.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Shop {
    private String id;

    private String name;

    private Integer phone;

    private Double latitude;

    private Double longitude;

    private String category;

    private String image_path;

    private Integer float_delivery_fee;

    private Integer float_minimum_order_amount;

    private String description;

    private String promotion_info;

    private Boolean is_premium;

    private Boolean delivery_mode;

    private Boolean is_new;

    private Boolean is_bao;

    private Boolean is_zhun;

    private Boolean is_piao;

    private Date startTime;

    private Date endTime;

    private String business_license_image;

    private String catering_service_license_image;

    private String activities;
}