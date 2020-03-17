package com.demo.link.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("chart_clothes")
public class Clothes {
    private String id;
    private String clothesName;
    private String sales;
    private String clothesDay;
    private String clothesPrice;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setClothesName(String clothesName) {
        this.clothesName = clothesName;
    }

    public String getClothesName() {
        return clothesName;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getSales() {
        return sales;
    }

    public void setClothesPrice(String clothesPrice) {
        this.clothesPrice = clothesPrice;
    }

    public String getClothesPrice() {
        return clothesPrice;
    }

    public void setClothesDay(String clothesDay) {
        this.clothesDay = clothesDay;
    }

    public String getClothesDay() {
        return clothesDay;
    }
}
