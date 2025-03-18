package com.org.vo;

import java.util.Date;

public class Steps extends HealthData {
    int steps;
    public Steps() {}
    public Steps(int id, int data, Date date) {
        this.id = id;
        steps = data;
        this.date = date;
    }

    @Override
    public void setData(double data) {
        steps = (int)data;
    }

    @Override
    public double getData() {
        return steps;
    }
}
