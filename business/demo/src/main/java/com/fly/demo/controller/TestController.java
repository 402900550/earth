package com.fly.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fly.demo.config.TestConfig;
import com.fly.demo.entity.LockHqbInRecord;
import com.fly.demo.eum.Status;
import com.fly.demo.service.ILockHqbInRecordService;
import com.fly.demo.util.HttpUtil;
import com.fly.demo.util.ImageCodeGenerator;
import com.fly.demo.util.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 *  
 *    
 *  @author liaoqinghui  
 *  @time 2019.07.04 17:37  
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private TestConfig testConfig;


    private ThreadLocal<String> imageCodes=new ThreadLocal<>();

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
        record.setStatus(Status.TWO);
        hqbInRecordService.save(record);
        //throw new RuntimeException();
    }

    @GetMapping("create")
    public void create() throws IOException {
        ImageCodeGenerator generator=new ImageCodeGenerator();
        String code = generator.getCode();
        HttpUtil.session().setAttribute("code",code);
        ThreadLocal<String> local=new ThreadLocal<>();
        local.set(code);
        log.info("code1,{}",local.get());
        local.set("sasdasd");
        log.info("code2,{}",local.get());
        local.remove();
        log.info("code3,{}",local.get());
        log.info("ip:{}", IpUtil.getIpAddress(HttpUtil.request()));
        generator.write(HttpUtil.response().getOutputStream());

    }

    @GetMapping("list")
    public List<LockHqbInRecord> list(Status status){
        List<LockHqbInRecord> list = hqbInRecordService.list();


        LockHqbInRecord record = new LockHqbInRecord();



        return list;
        //throw new RuntimeException();
    }

    @GetMapping("get")
    public String get(HttpServletRequest request){
        Object code =HttpUtil.session().getAttribute("code");
        String id = HttpUtil.session().getId();
        log.info("as:"+"_str".split("_")[0]);
        return id;
    }

    public static void main(String[] args){

        System.out.println(8%10);


    }

}
