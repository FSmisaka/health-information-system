package com.org.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class HealthGoal {

    private int goalId;  // goal_id
    private String username;  // user_id 改为 username
    private BigDecimal weightGoal;  // weight_goal
    private String fitnessGoal;  // fitness_goal
    private int exerciseDurationGoal;  // exercise_duration_goal
    private Timestamp createdAt;  // created_at
    private Timestamp updatedAt;  // updated_at

    // Getters and Setters
    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getWeightGoal() {
        return weightGoal;
    }

    public void setWeightGoal(BigDecimal weightGoal) {
        this.weightGoal = weightGoal;
    }

    public String getFitnessGoal() {
        return fitnessGoal;
    }

    public void setFitnessGoal(String fitnessGoal) {
        this.fitnessGoal = fitnessGoal;
    }

    public int getExerciseDurationGoal() {
        return exerciseDurationGoal;
    }

    public void setExerciseDurationGoal(int exerciseDurationGoal) {
        this.exerciseDurationGoal = exerciseDurationGoal;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
