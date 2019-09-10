package com.zfw.provider.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author hero良
 * @className JacksonEntity
 * @description TODO
 * @date 2019/9/10
 */
@Data
public class JacksonEntity {

    private String name;
    private int age;
    private String sex;
    private Double money;
    private Date date;
    private Timestamp timestamp;

    public JacksonEntity(String name, int age, String sex, Date date, Timestamp timestamp) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.date = date;
        this.timestamp = timestamp;
    }
}
