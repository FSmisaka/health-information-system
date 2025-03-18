package com.org.dao;

import com.org.vo.HealthGoal;
import com.org.dbc.DatabaseConnection;

import java.sql.*;
public class HealthGoalsDAO {

    // 保存健康目标
    public boolean saveHealthGoal(HealthGoal healthGoal) {
        String sql = "INSERT INTO health_goals (username, weight_goal, fitness_goal, exercise_duration_goal, created_at, updated_at) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, healthGoal.getUsername());
            stmt.setBigDecimal(2, healthGoal.getWeightGoal());
            stmt.setString(3, healthGoal.getFitnessGoal());
            stmt.setInt(4, healthGoal.getExerciseDurationGoal());
            stmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            stmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;  // 如果插入成功，返回true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
