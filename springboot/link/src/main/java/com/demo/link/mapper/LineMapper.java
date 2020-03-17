package com.demo.link.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.link.entity.Weekday;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LineMapper extends BaseMapper<Weekday> {
    List<Weekday> getWeiBo();

    List<Weekday> getWeiChat();

    List<Weekday> getTieBa();

    List<Weekday> getDouYin();

    List<Weekday> getKuaiShou();
}
