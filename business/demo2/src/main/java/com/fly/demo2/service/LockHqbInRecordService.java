package com.fly.demo2.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fly.demo2.entity.LockHqbInRecord;
import com.fly.demo2.mapper.LockHqbInRecordMapper;
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

    @Override
    public void modify() {
        LockHqbInRecord record=new LockHqbInRecord();
        record.setCoinSymbol("DEMO2");
        record.setMemberId(9999911L);
        this.save(record);

    }
}
