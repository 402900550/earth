package com.fly.demo.eum;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *  
 *    
 *  @author liaoqinghui  
 *  @time 2019.07.30 17:04  
 */
@Getter
@AllArgsConstructor
public enum Status implements IEnum<Integer> {

    ONE("111"),//0

    TWO("2222"),//1

    ;
    private String name;


    @Override
    @JsonValue
    public Integer getValue() {
        return this.ordinal();
    }
}
