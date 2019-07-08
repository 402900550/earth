package com.fly.ormmybatis.util;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.fly.ormmybatis.config.GengerateProperties;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *  
 *    
 *  @author liaoqinghui  
 *  @time 2019.07.08 09:36  
 */
public class CodeGengerater {

    private CodeGengerater() {

    }

    public static void gengerateCode(GengerateProperties properties) {
        File file=new File(properties.getPackageName());
        AutoGenerator generator = new AutoGenerator();

        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(properties.getFilePath() + "/src/main/java");
        globalConfig.setAuthor("qiliao");
        globalConfig.setOpen(false);
        globalConfig.setIdType(IdType.ID_WORKER);
        globalConfig.setMapperName("%sMapper");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");


        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(properties.getUrl());
        dataSourceConfig.setDriverName(properties.getDriverName());
        dataSourceConfig.setUsername(properties.getUsername());
        dataSourceConfig.setPassword(properties.getPassword());

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(properties.getModuleName());
        pc.setParent(properties.getPackageName());

        TemplateConfig templateConfig = new TemplateConfig();


        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude(properties.getTableNames());
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setEntityColumnConstant(true);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);


        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };

        generator.setCfg(injectionConfig);
        generator.setTemplate(templateConfig);
        generator.setTemplateEngine(new VelocityTemplateEngine());
        generator.setStrategy(strategyConfig);
        generator.setPackageInfo(pc);
        generator.setDataSource(dataSourceConfig);
        generator.setGlobalConfig(globalConfig);

        generator.execute();

    }




    public static void main(String[] args){

        GengerateProperties gengerateProperties=new GengerateProperties();
        gengerateProperties.setPackageName("com.fly.demo");
        gengerateProperties.setModuleName("ttttt");
        gengerateProperties.setTableNames("lock_coin_detail");
        gengerateProperties.setFilePath("F:\\earth\\business\\demo");

        gengerateCode(gengerateProperties);

    }

}
