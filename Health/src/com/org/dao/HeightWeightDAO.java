package com.org.dao;

import com.org.vo.HeightWeight;
import com.org.dbc.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class HeightWeightDAO {

    // 保存身高体重数据
    public boolean saveHeightWeight(HeightWeight heightWeight) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO height_weight (username, height, weight) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, heightWeight.getUsername());
            pstmt.setFloat(2, heightWeight.getHeight());
            pstmt.setFloat(3, heightWeight.getWeight());
            return pstmt.executeUpdate() > 0;  // 如果插入成功，返回true
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }
}