package com.fly.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fly.demo.config.TestConfig;
import com.fly.demo.entity.LockHqbInRecord;
import com.fly.demo.service.ILockHqbInRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  
 *    
 *  @author liaoqinghui  
 *  @time 2019.07.04 17:37  
 */
@RestController
public class TestController {

    @Autowired
    private TestConfig testConfig;

    @Autowired
    private ILockHqbInRecordService hqbInRecordService;

    @GetMapping("load")
    public List<LockHqbInRecord> load(){
        QueryWrapper<LockHqbInRecord> hqbInRecordQueryWrapper=new QueryWrapper<>();


        List<LockHqbInRecord> list = hqbInRecordService.list(hqbInRecordQueryWrapper);


        return list;
    }


    @PostMapping("add")
    public void add(){
        LockHqbInRecord record=new LockHqbInRecord();

        record.setCoinSymbol("DEMO1");
        record.setMemberId(99999L);
        hqbInRecordService.save(record);
        throw new RuntimeException();
    }

    public static void main(String[] args){

        System.out.println(8%10);


    }

}
