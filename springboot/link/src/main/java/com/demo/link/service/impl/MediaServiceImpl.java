package com.demo.link.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.link.entity.Media;
import com.demo.link.mapper.MediaMapper;
import com.demo.link.service.MediaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MediaServiceImpl extends ServiceImpl<MediaMapper, Media> implements MediaService {

    @Override
    public List<Media> getPie(Map<String, Object> params) {
        return baseMapper.getPie(params);
    }

    @Override
    public List<Media> getPieOut(Map<String, Object> params)  {
        return baseMapper.getPieOut(params);
    }

    @Override
    public List<Media> getPieIn(Map<String, Object> params) {return baseMapper.getPieIn(params);}
}
