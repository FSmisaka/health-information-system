package com.org.vo;

import java.util.Date;

public class BloodSugar extends HealthData {
    double bloodSugar;
    public BloodSugar() {}
    public BloodSugar(int id, double data, Date date) {
        this.id = id;
        bloodSugar = data;
        this.date = date;
    }

    @Override
    public void setData(double data) {
        bloodSugar = data;
    }

    @Override
    public double getData() {
        return bloodSugar;
    }
}
