package com.demo.link.cnotroller;

import com.demo.link.entity.Cloud;
import com.demo.link.service.CloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CloudController {
    @Autowired
    CloudService cloudService;

    @RequestMapping("getCloud")
    public List<Cloud> getCloud() {
        return cloudService.getCloud();
    }
}
