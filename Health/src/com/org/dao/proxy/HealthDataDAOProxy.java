package com.org.dao.proxy;

import com.org.dao.IHealthDataDAO;
import com.org.vo.HealthData;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class HealthDataDAOProxy implements IHealthDataDAO {
    private IHealthDataDAO dao;
    public HealthDataDAOProxy() {}
    public HealthDataDAOProxy(IHealthDataDAO dao) {
        this.dao = dao;
    }

    @Override
    public boolean addData(int id, double data) throws Exception {
        return dao.addData(id, data);
    }

    @Override
    public HealthData searchData(int id, Date date) throws Exception {
        return dao.searchData(id, date);
    }

    @Override
    public ArrayList<HealthData> dataTrend(int id) throws Exception {
        return dao.dataTrend(id);
    }

    @Override
    public boolean updateData(int id, double data, Date date) throws Exception {
        return dao.updateData(id, data, date);
    }

    @Override
    public boolean deleteData(int id, Date date) throws Exception {
        return dao.deleteData(id, date);
    }
}
