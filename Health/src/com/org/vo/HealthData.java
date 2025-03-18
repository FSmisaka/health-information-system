package com.org.vo;

import java.util.Date;

public abstract class HealthData {
    int id;
    Date date;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public abstract void setData(double data);
    public abstract double getData();
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
}
