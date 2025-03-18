package com.org.dao.impl;

import com.org.dao.IHealthDataDAO;
import com.org.vo.HealthData;
import com.org.vo.Weight;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class WeightDAOImpl implements IHealthDataDAO {
    private Connection conn = null;
    public WeightDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean addData(int id, double data) throws Exception {
        LocalDate today = LocalDate.now();
        String date = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String sql = "INSERT INTO weight(id, weight, setDate) VALUES(" + id + ", " + data + ", '" + date + "')";  //改
        Statement st = this.conn.createStatement();
        int row = st.executeUpdate(sql);
        return row>0 ? true : false;
    }

    @Override
    public Weight searchData(int id, Date dd) throws Exception {  //改
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dd);

        String sql = "SELECT * FROM weight WHERE id=" + id + " AND setDate='" + date + "'";  //改
        Statement st = this.conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        Weight data = null;  //改

        while(rs.next()) {
            data = new Weight();  //改
            data.setId(rs.getInt("id"));
            data.setData(rs.getDouble("weight"));  //改
            data.setDate(rs.getDate("setDate"));
        }
        return data;
    }

    @Override
    public ArrayList<HealthData> dataTrend(int id) throws Exception {
        ArrayList<HealthData> list = new ArrayList<>();
        String sql = "SELECT * FROM weight WHERE id=" + id + " ORDER BY setDate DESC";  //改
        Statement st = this.conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        int cnt=5; // 只取最近的5条记录
        while(rs.next() && cnt>0) {
            // 改
            list.add(new Weight(rs.getInt("id"), rs.getDouble("weight"), rs.getDate("setDate")));
            cnt--;
        }
        return list;
    }

    @Override
    public boolean updateData(int id, double data, Date dd) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dd);

        // 改
        String sql = "UPDATE weight SET weight=" + data + " WHERE id=" + id + " AND setDate='" + date + "'";
        Statement st = this.conn.createStatement();
        int row = st.executeUpdate(sql);
        return row>0 ? true : false;
    }

    @Override
    public boolean deleteData(int id, Date dd) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dd);

        String sql = "DELETE FROM weight WHERE id=" + id + " AND setDate='" + date + "'";  //改
        Statement st = this.conn.createStatement();
        int row = st.executeUpdate(sql);
        return row>0 ? true : false;
    }
}
