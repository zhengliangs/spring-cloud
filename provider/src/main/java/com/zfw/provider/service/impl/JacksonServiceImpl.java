package com.zfw.provider.service.impl;

import com.zfw.provider.entity.JacksonEntity;
import com.zfw.provider.service.JacksonService;
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
public class JacksonServiceImpl implements JacksonService {

    @Override
    public JacksonEntity getJacksonInfo() {
        return new JacksonEntity("Jackson", 22, "男", new Date(), new Timestamp(System.currentTimeMillis()));
    }
}
