package com.fly.demo2.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *  
 *    
 *  @author liaoqinghui  
 *  @time 2019.07.11 14:10  
 */
@FeignClient(name = "demo1")
public interface Demo1Feign {

    @PostMapping("add")
    void add();

}
