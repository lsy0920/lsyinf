package com.demo.link.cnotroller;

import com.demo.link.entity.Link;
import com.demo.link.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class LinkController {
    @Autowired
    LinkService linkService;

    @RequestMapping("getDepartment")
    public List<Link> getDepartment(@RequestParam Map<String, Object> params) {
        return linkService.getDepartment(params);
    }

    @RequestMapping("getOffice")
    public List<Link> getOffice(@RequestParam Map<String, Object> params) {
        return linkService.getOffice(params);
    }
}
