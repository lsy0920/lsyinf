package com.demo.link.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.link.entity.Link;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface LinkMapper extends BaseMapper<Link> {
    List<Link> getDepartment(@Param("params") Map<String, Object> params);

    List<Link> getOffice(@Param("params") Map<String, Object> params);
}
