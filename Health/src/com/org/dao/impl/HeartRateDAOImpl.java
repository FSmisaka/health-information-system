package com.org.dao.impl;

import com.org.dao.IHealthDataDAO;
import com.org.vo.HealthData;
import com.org.vo.HeartRate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class HeartRateDAOImpl implements IHealthDataDAO {
    private Connection conn = null;
    public HeartRateDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean addData(int id, double hr) throws Exception {
        LocalDate today = LocalDate.now();
        String date = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String sql = "INSERT INTO heartRate(id, heartRate, setDate) VALUES(" + id + ", " + (int)hr + ", '" + date + "')";
        Statement st = this.conn.createStatement();
        int row = st.executeUpdate(sql);
        return row>0 ? true : false;
    }

    @Override
    public HeartRate searchData(int id, Date dd) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dd);

        String sql = "SELECT * FROM heartRate WHERE id=" + id + " AND setDate='" + date + "'";
        Statement st = this.conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        HeartRate heartRate = null;

        while(rs.next()) {
            heartRate = new HeartRate();
            heartRate.setId(rs.getInt("id"));
            heartRate.setData(rs.getInt("heartRate"));
            heartRate.setDate(rs.getDate("setDate"));
        }
        return heartRate;
    }

    @Override
    public ArrayList<HealthData> dataTrend(int id) throws Exception {
        ArrayList<HealthData> list = new ArrayList<>();
        String sql = "SELECT * FROM heartRate WHERE id=" + id + " ORDER BY setDate DESC";
        Statement st = this.conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        int cnt=5; // 只取最近的5条记录
        while(rs.next() && cnt>0) {
            list.add(new HeartRate(rs.getInt("id"), rs.getInt("heartRate"), rs.getDate("setDate")));
            cnt--;
        }
        return list;
    }

    @Override
    public boolean updateData(int id, double heartRate, Date dd) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dd);

        String sql = "UPDATE heartRate SET heartRate=" + (int)heartRate + " WHERE id=" + id + " AND setDate='" + date + "'";
        Statement st = this.conn.createStatement();
        int row = st.executeUpdate(sql);
        return row>0 ? true : false;
    }

    @Override
    public boolean deleteData(int id, Date dd) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dd);

        String sql = "DELETE FROM heartRate WHERE id=" + id + " AND setDate='" + date + "'";
        Statement st = this.conn.createStatement();
        int row = st.executeUpdate(sql);
        return row>0 ? true : false;
    }
}
