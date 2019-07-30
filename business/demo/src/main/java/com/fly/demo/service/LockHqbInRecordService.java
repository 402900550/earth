package com.fly.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fly.demo.entity.LockHqbInRecord;
import com.fly.demo.mapper.LockHqbInRecordMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class LockHqbInRecordService extends ServiceImpl<LockHqbInRecordMapper,LockHqbInRecord> implements ILockHqbInRecordService{

    @Autowired
    private LockHqbInRecordMapper mapper;
    @Override
    public BigDecimal findTotal() {
        return mapper.findTotal();
    }
}
