package com.fly.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fly.demo.entity.LockHqbInRecord;

import java.math.BigDecimal;

/**
 * @author Zhang Yanjun
 * @time 2019.04.23 16:24
 */
public interface ILockHqbInRecordService extends IService<LockHqbInRecord> {


    BigDecimal findTotal();

}
