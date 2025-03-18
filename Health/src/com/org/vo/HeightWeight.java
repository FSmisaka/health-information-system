package com.org.vo;

public class HeightWeight {
    private String username;  // 用户名
    private float height;     // 身高
    private float weight;     // 体重

    // 构造函数
    public HeightWeight(String username, float height, float weight) {
        this.username = username;
        this.height = height;
        this.weight = weight;
    }

    // Getter 和 Setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
