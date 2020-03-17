package com.demo.link.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("chart_cloud")
public class Cloud {
    private String name;
    private String value;


    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
