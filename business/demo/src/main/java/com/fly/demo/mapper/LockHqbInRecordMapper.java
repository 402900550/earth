package com.fly.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fly.demo.entity.LockHqbInRecord;
import com.fly.demo.entity.SlaveStatus;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.Map;

@Mapper
public interface LockHqbInRecordMapper extends BaseMapper<LockHqbInRecord> {

    BigDecimal findTotal();



    Map<String,Object> findStatus();

    SlaveStatus findStatus2();

}
