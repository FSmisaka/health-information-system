package com.org.dao;

import com.org.vo.HealthData;

import java.util.ArrayList;
import java.util.Date;

public interface IHealthDataDAO {
    boolean addData(int id, double data) throws Exception;
    HealthData searchData(int id, Date date) throws Exception;
    ArrayList<HealthData> dataTrend(int id) throws Exception;
    boolean updateData(int id, double data, Date date) throws Exception;
    boolean deleteData(int id, Date date) throws Exception;
}