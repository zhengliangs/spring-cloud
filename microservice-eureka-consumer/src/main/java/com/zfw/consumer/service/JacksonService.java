package com.zfw.consumer.service;

import com.zfw.consumer.entity.JacksonEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author hero良
 * @className JacksonService
 * @description TODO
 * @date 2019/9/10
 */
@Service(value = "jacksonService")
public class JacksonService {

    public JacksonEntity getJacksonInfo() {
        return new JacksonEntity("Jackson", 22, "男", new Date(), new Timestamp(System.currentTimeMillis()));
    }
}
