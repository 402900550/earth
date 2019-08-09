package com.fly.ormmybatis.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  
 *    
 *  @author liaoqinghui  
 *  @time 2019.08.05 17:34  
 */
@Configuration
public class MybatisGlobalConfig {

    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
            return new OptimisticLockerInterceptor();
    }

}
