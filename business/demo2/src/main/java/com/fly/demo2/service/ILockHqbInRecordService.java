package com.fly.demo2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fly.demo2.entity.LockHqbInRecord;

import java.math.BigDecimal;

/**
 * @author Zhang Yanjun
 * @time 2019.04.23 16:24
 */
public interface ILockHqbInRecordService extends IService<LockHqbInRecord> {


    BigDecimal findTotal();

    void modify();
}
