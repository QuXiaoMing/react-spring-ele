package com.shellming.eleservice.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Goods {
    private Integer id;

    @NotEmpty
    private String name;

    private String remark;

    private Integer stock = 0;

    private Integer price = 0;

    private Integer sales = 0;

    private Integer praise_rate = 0;

    private String shop_id;

    private String user_id;

    private String status;

    private String images;

    private String category;
}