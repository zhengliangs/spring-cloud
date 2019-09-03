package com.zfw.provider.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserEntity {

    private Integer id;
    private String name;
    private int age;
    private int sex;
}
