package com.shellming.eleservice.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
public class Shop {
    private String id;

    @NotEmpty(message = "名称不能为空")
    private String name = "";

    @NotEmpty(message = "联系电话不能为空")
    private String phone = "";

    private Double latitude = 0.01;

    private Double longitude = 0.01;

    @NotEmpty(message = "门面地址不能为空")
    private String address = "";

    @NotEmpty(message = "分类不能为空")

    private String category = "";

    private String image_path = "";

    private Integer float_delivery_fee = 0;

    private Integer float_minimum_order_amount = 0;

    private String description = "";

    private String promotion_info = "";

    private Boolean is_premium = false;

    private Boolean delivery_mode = false;

    private Boolean is_new = false;

    private Boolean is_bao = false;

    private Boolean is_zhun = false;

    private Boolean is_piao = false;

    private Date createdAt = new Date();

    @NotNull(message = "startTime 不能为空")
    private Date startTime = new Date();

    @NotNull(message = "endTime 不能为空")
    private Date endTime;

    @NotNull(message = "business_license_image 不能为空")
    private String business_license_image  = "";


    @NotEmpty(message = "catering_service_license_image 不能为空")
    private String catering_service_license_image   = "";

    private String activities  = "";
}