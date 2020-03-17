package com.demo.link.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("department_link")
public class Link {
    private String id;
    private String department;
    private String departmentValue;
    private String office;
    private String officeValue;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getOffice() {
        return office;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartmentValue(String departmentValue) {
        this.departmentValue = departmentValue;
    }

    public String getDepartmentValue() {
        return departmentValue;
    }

    public void setOfficeValue(String officeValue) {
        this.officeValue = officeValue;
    }

    public String getOfficeValue() {
        return officeValue;
    }
}
