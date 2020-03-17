package com.demo.link.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.link.entity.Weekday;
import com.demo.link.mapper.LineMapper;
import com.demo.link.service.LineService;
import com.demo.link.service.LinkService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineServiceImpl extends ServiceImpl<LineMapper, Weekday> implements LineService {
    @Override
    public List<Weekday> getWeiBo() {
        return baseMapper.getWeiBo();
    }

    @Override
    public List<Weekday> getWeiChat() {
        return baseMapper.getWeiChat();
    }

    @Override
    public List<Weekday> getTieBa() {
        return baseMapper.getTieBa();
    }

    @Override
    public List<Weekday> getDouYin() {
        return baseMapper.getDouYin();
    }

    @Override
    public List<Weekday> getKuaiShou() {
        return baseMapper.getKuaiShou();
    }
}
