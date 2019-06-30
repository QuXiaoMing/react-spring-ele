package com.shellming.eleservice.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class Shop {
    private String id;

    @NotEmpty(message = "名称不能为空")
    private String name;

    @NotEmpty(message = "联系电话不能为空")
    private String phone;

    private Double latitude;

    private Double longitude;

    @NotEmpty(message = "门面地址不能为空")
    private String address;

    @NotEmpty(message = "分类不能为空")
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

    private Date createdAt;

    @NotNull(message = "startTime 不能为空")
    private Date startTime;

    @NotNull(message = "endTime 不能为空")
    private Date endTime;

    @NotNull(message = "endTime 不能为空")
    private String business_license_image;


    @NotEmpty(message = "catering_service_license_image 不能为空")
    private String catering_service_license_image;

    private String activities;
}