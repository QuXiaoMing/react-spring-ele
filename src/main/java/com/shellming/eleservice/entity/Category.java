package com.shellming.eleservice.entity;

import lombok.Data;

@Data
public class Category {
    private Integer id;

    private Integer parentId;

    private String name;
}