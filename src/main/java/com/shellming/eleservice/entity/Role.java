package com.shellming.eleservice.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@ToString
@Getter
@Setter
public class Role {
    private String id;
    private String name;
}