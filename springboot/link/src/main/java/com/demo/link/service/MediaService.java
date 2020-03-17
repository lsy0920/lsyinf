package com.demo.link.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.link.entity.Media;

import java.util.List;
import java.util.Map;

public interface MediaService extends IService<Media> {

    List<Media> getPie(Map<String, Object> params);

    List<Media> getPieOut(Map<String, Object> params);

    List<Media> getPieIn(Map<String, Object> params);
}
