package com.fly.demo.controller;

import com.fly.demo.service.ILockHqbInRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  
 *    
 *  @author liaoqinghui  
 *  @time 2019.08.22 11:06  
 */
@RestController
@Slf4j
public class TestAsync {

    @Autowired
    private ILockHqbInRecordService lockHqbInRecordService;

    @GetMapping("async")
    public void async(){
        log.info("=============main:{}",Thread.currentThread().getName());

        lockHqbInRecordService.testAsync();

    }


}
