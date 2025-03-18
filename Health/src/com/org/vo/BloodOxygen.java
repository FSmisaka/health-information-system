package com.org.vo;

import java.util.Date;

public class BloodOxygen extends HealthData {
    double bloodOxygen;
    public BloodOxygen() {}
    public BloodOxygen(int id, double data, Date date) {
        this.id = id;
        bloodOxygen = data;
        this.date = date;
    }

    @Override
    public void setData(double data) {
        bloodOxygen = data;
    }

    @Override
    public double getData() {
        return bloodOxygen;
    }
}
