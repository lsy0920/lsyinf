package com.demo.link.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.link.entity.Clothes;

import java.util.List;
import java.util.Map;

public interface ClothesService extends IService<Clothes> {
    List<Clothes> getClothesList(Map<String, Object> params);

    List<Clothes> getDay(Map<String, Object> params);

}
