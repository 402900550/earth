package com.fly.demo2.controller;

import com.fly.demo2.biz.TestBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  
 *    
 *  @author liaoqinghui  
 *  @time 2019.07.04 17:37  
 */
@RestController
public class TestController {


    @Autowired
    private TestBiz testBiz;

    @GetMapping("load")
    public void load(){

        testBiz.ddodo();

    }




}
