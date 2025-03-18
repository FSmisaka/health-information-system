package com.org.vo;

import java.util.Date;

public class Weight extends HealthData {
    double weight;
    public Weight() {}
    public Weight(int id, double data, Date date) {
        this.id = id;
        weight = data;
        this.date = date;
    }

    @Override
    public void setData(double data) {
        weight = data;
    }

    @Override
    public double getData() {
        return weight;
    }
}
