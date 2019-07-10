package com.shellming.eleservice.entity;

import lombok.Data;

@Data
public class Goods {
    private Integer id;

    private String name;

    private String remark;

    private Integer stock;

    private Integer price;

    private Integer sales;

    private Integer praise_rate;

    private String shop_id;

    private String user_id;

    private String status;

    private String images;

}