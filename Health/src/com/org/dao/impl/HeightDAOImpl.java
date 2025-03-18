package com.org.dao.impl;

import com.org.dao.IHealthDataDAO;
import com.org.vo.HealthData;
import com.org.vo.Height;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class HeightDAOImpl implements IHealthDataDAO {
    private Connection conn = null;
    public HeightDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean addData(int id, double data) throws Exception {
        LocalDate today = LocalDate.now();
        String date = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String sql = "INSERT INTO height(id, height, setDate) VALUES(" + id + ", " + data + ", '" + date + "')";
        Statement st = this.conn.createStatement();
        int row = st.executeUpdate(sql);
        return row>0 ? true : false;
    }

    @Override
    public Height searchData(int id, Date dd) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dd);

        String sql = "SELECT * FROM height WHERE id=" + id + " AND setDate='" + date + "'";
        Statement st = this.conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        Height data = null;

        while(rs.next()) {
            data = new Height();
            data.setId(rs.getInt("id"));
            data.setData(rs.getDouble("height"));
            data.setDate(rs.getDate("setDate"));
        }
        return data;
    }

    @Override
    public ArrayList<HealthData> dataTrend(int id) throws Exception {
        ArrayList<HealthData> list = new ArrayList<>();
        String sql = "SELECT * FROM height WHERE id=" + id + " ORDER BY setDate DESC";
        Statement st = this.conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        int cnt=5; // 只取最近的5条记录
        while(rs.next() && cnt>0) {
            list.add(new Height(rs.getInt("id"), rs.getDouble("height"), rs.getDate("setDate")));
            cnt--;
        }
        return list;
    }

    @Override
    public boolean updateData(int id, double data, Date dd) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dd);

        String sql = "UPDATE height SET height=" + data + " WHERE id=" + id + " AND setDate='" + date + "'";
        Statement st = this.conn.createStatement();
        int row = st.executeUpdate(sql);
        return row>0 ? true : false;
    }

    @Override
    public boolean deleteData(int id, Date dd) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dd);

        String sql = "DELETE FROM height WHERE id=" + id + " AND setDate='" + date + "'";
        Statement st = this.conn.createStatement();
        int row = st.executeUpdate(sql);
        return row>0 ? true : false;
    }
}
