package com.demo.link.cnotroller;

import com.demo.link.entity.Weekday;
import com.demo.link.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LineController {
    @Autowired
    LineService lineService;

    @RequestMapping("getWeiBo")
    public List<Weekday> getWeiBo() {
        return lineService.getWeiBo();
    }

    @RequestMapping("getWeiChat")
    public List<Weekday> getWeiChat() {
        return lineService.getWeiChat();
    }

    @RequestMapping("getTieBa")
    public List<Weekday> getTieBa() {
        return lineService.getTieBa();
    }

    @RequestMapping("getDouYin")
    public List<Weekday> getDouYin() {
        return lineService.getDouYin();
    }

    @RequestMapping("getKuaiShou")
    public List<Weekday> getKuaiShou() {
        return lineService.getKuaiShou();
    }
}
