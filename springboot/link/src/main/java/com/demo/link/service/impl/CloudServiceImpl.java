package com.demo.link.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.link.entity.Cloud;
import com.demo.link.mapper.CloudMapper;
import com.demo.link.service.CloudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudServiceImpl extends ServiceImpl<CloudMapper, Cloud> implements CloudService {
    @Override
    public List<Cloud> getCloud() {
        return baseMapper.getCloud();
    }
}
