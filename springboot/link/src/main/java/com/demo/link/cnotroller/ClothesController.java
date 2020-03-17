package com.demo.link.cnotroller;

import com.demo.link.entity.Clothes;
import com.demo.link.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ClothesController {
    @Autowired
    ClothesService clothesService;

    @RequestMapping("getClothesList")
    public List<Clothes> getClothesList(@RequestParam Map<String, Object> params) {
        return clothesService.getClothesList(params);
    }

    @RequestMapping("getDay")
    public List<Clothes> getDay(@RequestParam Map<String, Object> params) {
        return clothesService.getDay(params);
    }

}
