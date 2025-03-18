package com.org.vo;

import java.util.Date;

public class HeartRate extends HealthData {
    int heartRate;
    public HeartRate() {}
    public HeartRate(int id, int hr, Date date) {
        this.id = id;
        heartRate = hr;
        this.date = date;
    }

    @Override
    public void setData(double data) {
        heartRate = (int)data;
    }

    @Override
    public double getData() {
        return heartRate;
    }
}
