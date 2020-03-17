package com.demo.link.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.link.entity.Link;
import com.demo.link.mapper.LinkMapper;
import com.demo.link.service.LinkService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {
    @Override
    public List<Link> getDepartment(Map<String, Object> params) {
        return baseMapper.getDepartment(params);
    }

    @Override
    public List<Link> getOffice(Map<String, Object> params) {
        return baseMapper.getOffice(params);
    }
}
