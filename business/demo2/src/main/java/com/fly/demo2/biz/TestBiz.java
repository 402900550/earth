package com.fly.demo2.biz;

import com.fly.demo2.feign.Demo1Feign;
import com.fly.demo2.service.ILockHqbInRecordService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  
 *    
 *  @author liaoqinghui  
 *  @time 2019.07.11 14:15  
 */
@Service
public class TestBiz {

    @Autowired
    private Demo1Feign feign;


    @Autowired
    private ILockHqbInRecordService service;


    @GlobalTransactional(rollbackFor = Exception.class)
    public void ddodo(){
        service.modify();


        feign.add();


    }
}
