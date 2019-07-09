package com.shellming.eleservice.entity;

import lombok.Data;

import java.util.List;

@Data
public class Category {
    private Integer id;

    private Integer parentId;

    private String name;

    private List children;
}