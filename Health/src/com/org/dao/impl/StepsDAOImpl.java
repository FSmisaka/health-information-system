package com.org.dao.impl;

import com.org.dao.IHealthDataDAO;
import com.org.vo.BloodPressure;
import com.org.vo.HealthData;
import com.org.vo.Steps;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class StepsDAOImpl implements IHealthDataDAO {
    private Connection conn = null;
    public StepsDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean addData(int id, double data) throws Exception {
        LocalDate today = LocalDate.now();
        String date = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String sql = "INSERT INTO steps(id, steps, setDate) VALUES(" + id + ", " + (int)data + ", '" + date + "')";
        Statement st = this.conn.createStatement();
        int row = st.executeUpdate(sql);
        return row>0 ? true : false;
    }

    @Override
    public Steps searchData(int id, Date dd) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dd);

        String sql = "SELECT * FROM steps WHERE id=" + id + " AND setDate='" + date + "'";
        Statement st = this.conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        Steps data = null;

        while(rs.next()) {
            data = new Steps();
            data.setId(rs.getInt("id"));
            data.setData(rs.getInt("steps"));
            data.setDate(rs.getDate("setDate"));
        }
        return data;
    }

    @Override
    public ArrayList<HealthData> dataTrend(int id) throws Exception {
        ArrayList<HealthData> list = new ArrayList<>();
        String sql = "SELECT * FROM steps WHERE id=" + id + " ORDER BY setDate DESC";
        Statement st = this.conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        int cnt=5; // 只取最近的5条记录
        while(rs.next() && cnt>0) {
            list.add(new Steps(rs.getInt("id"), rs.getInt("steps"), rs.getDate("setDate")));
            cnt--;
        }
        return list;
    }

    @Override
    public boolean updateData(int id, double data, Date dd) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dd);

        String sql = "UPDATE steps SET steps=" + (int)data + " WHERE id=" + id + " AND setDate='" + date + "'";
        Statement st = this.conn.createStatement();
        int row = st.executeUpdate(sql);
        return row>0 ? true : false;
    }

    @Override
    public boolean deleteData(int id, Date dd) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dd);

        String sql = "DELETE FROM steps WHERE id=" + id + " AND setDate='" + date + "'";
        Statement st = this.conn.createStatement();
        int row = st.executeUpdate(sql);
        return row>0 ? true : false;
    }
}
