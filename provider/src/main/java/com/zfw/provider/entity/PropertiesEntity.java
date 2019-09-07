package com.zfw.provider.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取配置文件的数据
 * 需要把类交给spring容器来管理
 * prefix指定配置文件中的前缀
 */
@Component
@ConfigurationProperties(prefix = "test")
@Data
public class PropertiesEntity {

    private String name;
    private String path;
    private int index;
}
