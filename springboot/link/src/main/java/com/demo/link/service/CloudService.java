package com.demo.link.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.link.entity.Cloud;

import java.util.List;

public interface CloudService extends IService<Cloud> {
    List<Cloud> getCloud();
}
