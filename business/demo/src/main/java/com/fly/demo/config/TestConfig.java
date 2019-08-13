package com.fly.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 *  
 *    
 *  @author liaoqinghui  
 *  @time 2019.07.04 17:38  
 */
@Data
@Component
@ConfigurationProperties(prefix = "test.config")
public class TestConfig {


    private String port1;

    private String port2;

    private String hui;

    private String kkk;

    private String ext1;

    private String ext2;

}
