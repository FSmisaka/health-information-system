package com.org.vo;
import java.util.Date;

public class BloodPressure extends HealthData{
    int bloodPressure;
    public BloodPressure() {}
    public BloodPressure(int id, int bloodPressure, Date date) {
        this.id = id;
        this.bloodPressure = bloodPressure;
        this.date = date;
    }

    @Override
    public void setData(double data) {
        bloodPressure = (int)data;
    }

    @Override
    public double getData() {
        return bloodPressure;
    }
}
