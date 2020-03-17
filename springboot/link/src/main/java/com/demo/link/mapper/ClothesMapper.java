package com.demo.link.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.link.entity.Clothes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClothesMapper extends BaseMapper<Clothes> {
    List<Clothes> getClothesList(@Param("params") Map<String, Object> params);

    List<Clothes> getDay(@Param("params") Map<String, Object> params);



}
