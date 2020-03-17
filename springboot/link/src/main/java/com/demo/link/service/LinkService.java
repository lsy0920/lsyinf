package com.demo.link.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.link.entity.Link;

import java.util.List;
import java.util.Map;

public interface LinkService extends IService<Link> {
    List<Link> getDepartment(Map<String, Object> params);

    List<Link> getOffice(Map<String, Object> params);
}
