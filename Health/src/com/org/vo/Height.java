package com.org.vo;

import java.util.Date;

public class Height extends HealthData {
    double height;
    public Height() {}
    public Height(int id, double data, Date date) {
        this.id = id;
        height = data;
        this.date = date;
    }

    @Override
    public void setData(double data) {
        height = data;
    }

    @Override
    public double getData() {
        return height;
    }
}
