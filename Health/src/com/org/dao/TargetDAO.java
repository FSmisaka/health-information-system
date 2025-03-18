package com.org.dao;

import com.org.vo.Target;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.org.dbc.DatabaseConnection;  // 引入已有的数据库连接工具类

public class TargetDAO {

    // 无参构造方法
    public TargetDAO() {

    }

    // 插入目标数据
    public boolean insertTarget(Target target) throws SQLException {
        String sql = "INSERT INTO target (username, created_at, focus, way, deadline) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, target.getUsername());
            stmt.setTimestamp(2, new Timestamp(target.getCreatedAt().getTime()));
            stmt.setString(3, target.getFocus());
            stmt.setString(4, target.getWay());
            stmt.setString(5, target.getDeadline());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    // 获取所有目标
    public List<Target> getAllTargets() throws SQLException {
        String sql = "SELECT * FROM target";
        List<Target> targets = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Target target = new Target(
                        rs.getInt("target_id"),
                        rs.getString("username"),
                        rs.getTimestamp("created_at"),
                        rs.getString("focus"),
                        rs.getString("way"),
                        rs.getString("deadline")
                );
                targets.add(target);
            }
        }
        return targets;
    }

    // 查询最近五条目标
    public List<Target> getRecentTargets(String username, int limit) throws SQLException {
        String sql = "SELECT * FROM target WHERE username = ? ORDER BY created_at DESC LIMIT ?";
        List<Target> targets = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);  // 设置 username 参数
            stmt.setInt(2, limit);  // 设置 limit 参数
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Target target = new Target(
                        rs.getInt("target_id"),
                        rs.getString("username"),
                        rs.getTimestamp("created_at"),
                        rs.getString("focus"),
                        rs.getString("way"),
                        rs.getString("deadline")
                );
                targets.add(target);
            }
        }
        return targets;
    }


    // 根据ID获取目标
    public Target getTargetById(int targetId) throws SQLException {
        String sql = "SELECT * FROM target WHERE target_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, targetId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Target(
                            rs.getInt("target_id"),
                            rs.getString("username"),
                            rs.getTimestamp("created_at"),
                            rs.getString("focus"),
                            rs.getString("way"),
                            rs.getString("deadline")
                    );
                }
            }
        }
        return null;
    }
}
