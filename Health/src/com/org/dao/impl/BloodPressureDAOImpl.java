package com.org.dao.impl;

import com.org.dao.IHealthDataDAO;
import com.org.vo.BloodPressure;
import com.org.vo.HealthData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class BloodPressureDAOImpl implements IHealthDataDAO {
    private Connection conn = null;
    public BloodPressureDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean addData(int id, double bloodPressure) throws Exception {
        LocalDate today = LocalDate.now();
        String date = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String sql = "INSERT INTO bloodPressure(id, bloodPressure, setDate) VALUES(" + id + ", " + (int)bloodPressure + ", '" + date + "')";
        Statement st = this.conn.createStatement();
        int row = st.executeUpdate(sql);
        return row>0 ? true : false;
    }

    @Override
    public BloodPressure searchData(int id, Date dd) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dd);

        String sql = "SELECT * FROM bloodPressure WHERE id=" + id + " AND setDate='" + date + "'";
        Statement st = this.conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        BloodPressure bloodPressure = null;

        while(rs.next()) {
            bloodPressure = new BloodPressure();
            bloodPressure.setId(rs.getInt("id"));
            bloodPressure.setData(rs.getInt("bloodPressure"));
            bloodPressure.setDate(rs.getDate("setDate"));
        }
        return bloodPressure;
    }

    @Override
    public ArrayList<HealthData> dataTrend(int id) throws Exception {
        ArrayList<HealthData> list = new ArrayList<>();
        String sql = "SELECT * FROM bloodPressure WHERE id=" + id + " ORDER BY setDate DESC";
        Statement st = this.conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        int cnt=5; // 只取最近的5条记录
        while(rs.next() && cnt>0) {
            list.add(new BloodPressure(rs.getInt("id"), rs.getInt("bloodPressure"), rs.getDate("setDate")));
            cnt--;
        }
        return list;
    }

    @Override
    public boolean updateData(int id, double bloodPressure, Date dd) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dd);

        String sql = "UPDATE bloodPressure SET bloodPressure=" + (int)bloodPressure + " WHERE id=" + id + " AND setDate='" + date + "'";
        Statement st = this.conn.createStatement();
        int row = st.executeUpdate(sql);
        return row>0 ? true : false;
    }

    @Override
    public boolean deleteData(int id, Date dd) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dd);

        String sql = "DELETE FROM bloodPressure WHERE id=" + id + " AND setDate='" + date + "'";
        Statement st = this.conn.createStatement();
        int row = st.executeUpdate(sql);
        return row>0 ? true : false;
    }
}
