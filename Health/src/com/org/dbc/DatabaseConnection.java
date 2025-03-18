package com.org.dbc;

import java.sql.*;

public class DatabaseConnection {
    private static final String Driver = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/health_information_system";
    private static final String USER = "root";
    private static final String PASSWORD = "123123";

    // 获取数据库连接
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(Driver); // 加载数据库驱动
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("数据库连接失败", e);
        }
    }
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
