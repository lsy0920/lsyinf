package com.demo.link.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.link.entity.Clothes;
import com.demo.link.mapper.ClothesMapper;
import com.demo.link.service.ClothesService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

@Service
public class ClothesServiceImpl extends ServiceImpl<ClothesMapper, Clothes> implements ClothesService {
    @Override
    public List<Clothes> getClothesList(Map<String, Object> params) {
        return baseMapper.getClothesList(params);
    }

    @Override
    public List<Clothes> getDay(Map<String, Object> params) {
        return baseMapper.getDay(params);
    }


}
