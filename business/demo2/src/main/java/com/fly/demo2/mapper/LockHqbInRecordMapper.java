package com.fly.demo2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fly.demo2.entity.LockHqbInRecord;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

@Mapper
public interface LockHqbInRecordMapper extends BaseMapper<LockHqbInRecord> {

    BigDecimal findTotal();
}
