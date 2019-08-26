package com.fly.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fly.demo.entity.LockHqbInRecord;
import com.fly.demo.entity.SlaveStatus;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author Zhang Yanjun
 * @time 2019.04.23 16:24
 */
public interface ILockHqbInRecordService extends IService<LockHqbInRecord> {


    BigDecimal findTotal();

    Map<String,Object> findStatus();

    SlaveStatus findStatus2();

    List<LockHqbInRecord> findAll();

    void testAsync();
}
