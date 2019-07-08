package com.fly.demo.controller;

import com.fly.demo.config.TestConfig;
import com.fly.demo.entity.LockHqbInRecord;
import com.fly.demo.service.ILockHqbInRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
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
    @Transactional
    public List<LockHqbInRecord> load(){
        String ext1 = testConfig.getHui();
        String ext2 = testConfig.getKkk();
        List<LockHqbInRecord> list = hqbInRecordService.list();

        LockHqbInRecord record=new LockHqbInRecord();
        record.setAppId("34343");
        record.setApplyAmount(BigDecimal.ZERO);
        record.setCoinSymbol("BCCC");
        hqbInRecordService.save(record);
        return list;
    }



    public static void main(String[] args){

        System.out.println(8%10);


    }

}
