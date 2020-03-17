package com.demo.link.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("chart_line")
public class Weekday {
    private String LineMedia;
    private String LinePageview;
    private String LineWeekday;

    public String getLineMedia() {
        return LineMedia;
    }

    public void setLineMedia(String lineMedia) {
        LineMedia = lineMedia;
    }

    public String getLinePageview() {
        return LinePageview;
    }

    public void setLinePageview(String linePageview) {
        LinePageview = linePageview;
    }

    public String getLineWeekday() {
        return LineWeekday;
    }

    public void setLineWeekday(String lineWeekday) {
        LineWeekday = lineWeekday;
    }
}
