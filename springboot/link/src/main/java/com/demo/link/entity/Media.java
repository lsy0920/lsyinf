package com.demo.link.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("chart_pie")
public class Media {
    private String name;
    private String value;
    private String pieSort;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setPieSort(String pieSort) {
        this.pieSort = pieSort;
    }

    public String getPieSort() {
        return pieSort;
    }
}
