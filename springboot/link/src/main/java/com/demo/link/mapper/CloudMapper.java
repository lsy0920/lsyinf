package com.demo.link.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.link.entity.Cloud;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CloudMapper extends BaseMapper<Cloud> {
    List<Cloud> getCloud();
}
