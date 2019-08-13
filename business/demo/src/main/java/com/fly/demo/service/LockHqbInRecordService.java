package com.fly.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fly.demo.entity.LockHqbInRecord;
import com.fly.demo.entity.SlaveStatus;
import com.fly.demo.mapper.LockHqbInRecordMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class LockHqbInRecordService extends ServiceImpl<LockHqbInRecordMapper, LockHqbInRecord> implements ILockHqbInRecordService {

    @Autowired
    private LockHqbInRecordMapper mapper;

    @Override
    public BigDecimal findTotal() {
        return mapper.findTotal();
    }

    @Cacheable(cacheNames = "lockHqbInrecords",key = "'list:lockHqbInrecords'")
    public List<LockHqbInRecord> findAll() {
        return this.list();
    }

    @Override
    public Map<String, Object> findStatus() {
        return mapper.findStatus();
    }

    @Override
    public SlaveStatus findStatus2() {
        return mapper.findStatus2();
    }


}
