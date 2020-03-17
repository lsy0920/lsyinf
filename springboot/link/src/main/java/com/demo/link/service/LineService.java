package com.demo.link.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.link.entity.Weekday;

import java.util.List;

public interface LineService extends IService<Weekday> {
    List<Weekday> getWeiBo();

    List<Weekday> getWeiChat();

    List<Weekday> getTieBa();

    List<Weekday> getDouYin();

    List<Weekday> getKuaiShou();

}
