package com.demo.link.cnotroller;

import com.demo.link.entity.Media;
import com.demo.link.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MediaController {
    @Autowired
    MediaService mediaService;

    @RequestMapping("getPie")
    public List<Media> getPie(@RequestParam Map<String, Object> params) {
        return mediaService.getPie(params);
    }

    @RequestMapping("getPieOut")
    public List<Media> getPieOut(@RequestParam Map<String, Object> params) {
        return mediaService.getPieOut(params);
    }

    @RequestMapping("getPieIn")
    public List<Media> getPieIn(@RequestParam Map<String, Object> params) {return mediaService.getPieIn(params);}
}
