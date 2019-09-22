package com.opot.count.service;

import com.opot.count.entity.Count;
import com.opot.count.mapper.CountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountService implements CountMapper {
    @Autowired
    private CountMapper countMapper;

    @Override
    public long getUsersNum() {
        return countMapper.getUsersNum();
    }

    @Override
    public long getDaySearchNum(int day) {
        return countMapper.getDaySearchNum(day);
    }

    @Override
    public List<Integer> getDayUsers() {
        return countMapper.getDayUsers();
    }

    @Override
    public Count getUserInfo(Integer uid) {
        return countMapper.getUserInfo(uid);
    }
}
