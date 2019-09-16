package com.zfw.consumer.service.impl;

import com.zfw.consumer.entity.JacksonEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author hero良
 * @className JacksonServiceImpl
 * @description TODO
 * @date 2019/9/10
 */
@Service(value = "jacksonService")
public class JacksonServiceImpl{

    public JacksonEntity getJacksonInfo() {
        return new JacksonEntity("Jackson", 22, "男", new Date(), new Timestamp(System.currentTimeMillis()));
    }
}
