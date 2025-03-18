package com.org.vo;

import java.util.Date;

public class Target {
    private int targetId;            // 目标ID
    private String username;         // 用户名
    private Date createdAt;          // 创建时间
    private String focus;            // 当前主要关注的健康指标
    private String way;              // 希望改善的主要方式
    private String deadline;         // 目标完成期限

    // 构造方法
    public Target(int targetId, String username, Date createdAt, String focus, String way, String deadline) {
        this.targetId = targetId;
        this.username = username;     // 修改为 username
        this.createdAt = createdAt;
        this.focus = focus;
        this.way = way;
        this.deadline = deadline;
    }

    public Target() {

    }

    // Getter 和 Setter 方法
    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public String getUsername() {
        return username;  // 返回用户名
    }

    public void setUsername(String username) {
        this.username = username;  // 设置用户名
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
