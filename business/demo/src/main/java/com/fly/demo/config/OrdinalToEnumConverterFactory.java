package com.fly.demo.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import java.util.HashMap;
import java.util.Map;

/**
 *  
 *    
 *  @author liaoqinghui  
 *  @time 2019.07.31 16:29  
 */
public class OrdinalToEnumConverterFactory implements ConverterFactory<String, Enum<?>> {

    @Override
    public <T extends Enum<?>> Converter<String, T> getConverter(Class<T> targetType) {
        return new OrdinalToEnum<>(targetType);
    }

    private class OrdinalToEnum<T extends Enum<?>> implements Converter<String, T> {

        //private final Class<T> enumType;

        private Map<String, T> enumMap = new HashMap<>();

        public OrdinalToEnum(Class<T> enumType) {
            //this.enumType = enumType;
            T[] enums = enumType.getEnumConstants();
            for (T e : enums) {
                enumMap.put(String.valueOf(e.ordinal()), e);
            }
        }

        @Override
        public T convert(String source) {
            T result = enumMap.get(source);
            if (result == null) {
                throw new IllegalArgumentException("No element matches " + source);
            }
            return result;
        }
    }
}
