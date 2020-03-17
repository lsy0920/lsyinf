package com.demo.link.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.link.entity.Media;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MediaMapper extends BaseMapper<Media> {

    List<Media> getPie(@Param("params") Map<String, Object> params);

    List<Media> getPieOut(@Param("params") Map<String, Object> params);

    List<Media> getPieIn(@Param("params") Map<String, Object> params);
}
