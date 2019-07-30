package com.fly.ormmybatis.config;

import lombok.Data;

/**
 *  
 *    
 *  @author liaoqinghui  
 *  @time 2019.07.08 09:38  
 */
@Data
public class GengerateProperties {

    private String driverName="com.mysql.jdbc.Driver";

    private String url="jdbc:mysql://localhost:3306/otc_sync?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private String username="root";

    private String password="root";


    private String moduleName;


    private String packageName;


    private String tableNames;


    private String filePath="F:\\earth\\core\\orm-mybatis";
}
