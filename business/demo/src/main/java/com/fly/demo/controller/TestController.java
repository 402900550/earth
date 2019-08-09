package com.fly.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fly.demo.config.TestConfig;
import com.fly.demo.entity.ImageVo;
import com.fly.demo.entity.LockHqbInRecord;
import com.fly.demo.entity.SlaveStatus;
import com.fly.demo.eum.Status;
import com.fly.demo.gif.Captcha;
import com.fly.demo.gif.GifCaptcha;
import com.fly.demo.service.ILockHqbInRecordService;
import com.fly.demo.util.HttpUtil;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Properties;

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


    private ThreadLocal<String> imageCodes = new ThreadLocal<>();

    @Autowired
    private ILockHqbInRecordService hqbInRecordService;

    @GetMapping("load")
    public List<LockHqbInRecord> load() {
        QueryWrapper<LockHqbInRecord> hqbInRecordQueryWrapper = new QueryWrapper<>();
        List<LockHqbInRecord> list = hqbInRecordService.list(hqbInRecordQueryWrapper);
        return list;
    }

    @PostMapping("add")
    public void add() {
        LockHqbInRecord record = new LockHqbInRecord();
        record.setCoinSymbol("DEMO1");
        record.setMemberId(99999L);
        record.setStatus(Status.TWO);
        hqbInRecordService.save(record);
        //throw new RuntimeException();
    }

    @GetMapping("create")
    public ImageVo create() throws IOException {
        String code = captchaProducer.createText();
        BufferedImage image = captchaProducer.createImage(code);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image,"png",outputStream);
        Base64.Encoder encoder = Base64.getEncoder();

        String baseUrl = "data:image/png;base64," + encoder.encodeToString(outputStream.toByteArray());
        String timeKey = "key" + System.currentTimeMillis();
        log.info("code:{}", code);
        return ImageVo.builder().url(baseUrl).timeKey("key" + System.currentTimeMillis()).build();


    }

    @Autowired
    private DefaultKaptcha captchaProducer;

    @GetMapping("create2")
    public void create2(HttpServletResponse response) throws IOException {
        //ImageCodeGenerator generator = new ImageCodeGenerator();
        // generator.createCode();
        //generator.write(response.getOutputStream());


//        String capText = captchaProducer.createText();
//        log.info("code:{}", capText);
//        BufferedImage bi = captchaProducer.createImage(capText);
//        ServletOutputStream out = response.getOutputStream();
//        // write the data out
//        ImageIO.write(bi, "jpg", out);


        Map<String,Object> status = hqbInRecordService.findStatus();

        SlaveStatus status2 = hqbInRecordService.findStatus2();

        Captcha s=new GifCaptcha();
        String text = s.text();
        s.out(response.getOutputStream());


    }


    @GetMapping("list")
    public List<LockHqbInRecord> list(Status status) {
        List<LockHqbInRecord> list = hqbInRecordService.list();


        LockHqbInRecord record = new LockHqbInRecord();


        return list;
        //throw new RuntimeException();
    }

    @GetMapping("get")
    public String get(HttpServletRequest request) {
        Object code = HttpUtil.session().getAttribute("code");
        String id = HttpUtil.session().getId();
        log.info("as:" + "_str".split("_")[0]);
        return id;
    }



    public static void main(String[] args) {
        System.out.println(8 % 10);
//        JPushClient
//         pushClient=new JPushClient("","");
//        PushPayload payload=PushPayload.newBuilder().setNotification(null).build();
//
//        PushResult result=pushClient.sendPush(payload);
    }


    @Bean(name = "captchaProducer")
    public DefaultKaptcha getKaptchaBean() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty("kaptcha.border", "yes");
        properties.setProperty("kaptcha.border.color", "105,179,90");
        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        properties.setProperty("kaptcha.image.width", "125");
        properties.setProperty("kaptcha.image.height", "45");
        properties.setProperty("kaptcha.session.key", "code");
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;

    }
}