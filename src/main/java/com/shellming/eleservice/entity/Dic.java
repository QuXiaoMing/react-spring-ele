package com.shellming.eleservice.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Dic {
    private String id;

    @NotEmpty
    private String key;

    @NotEmpty
    private String name;

    @NotEmpty
    private String value;

    @NotEmpty
    private String text;
}