CREATE DATABASE IF NOT EXISTS health_information_system;

USE health_information_system;

-- 1.创建 users 表
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    avatar VARCHAR(255),
    name VARCHAR(50),
    birthday DATE,
    gender VARCHAR(50),
    blood_type VARCHAR(50),
    contact_email VARCHAR(100),
    contact_phone VARCHAR(15),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE height_weight (
    username VARCHAR(50) NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    height FLOAT,  -- 身高（单位：cm）
    weight FLOAT,  -- 体重（单位：kg）
    PRIMARY KEY (username, timestamp),
    FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE
);



CREATE TABLE target (
    target_id INT AUTO_INCREMENT PRIMARY KEY,                           -- 自增的主键 target_id
    username VARCHAR(50) NOT NULL,                                       -- 用户名，外键引用 users 表
    created_at TIMESTAMP NOT NULL,                                       -- 目标创建时间
    focus ENUM('weight', 'blood_sugar', 'blood_pressure') NOT NULL,     -- 当前主要关注的健康指标
    way ENUM('diet_control', 'increase_exercise') NOT NULL,             -- 希望改善的主要方式
    deadline ENUM('one_week', 'one_month', 'three_months', 'six_months') NOT NULL,  -- 目标完成期限
    CONSTRAINT UNIQUE (target_id, username),                            -- target_id 和 username 共同组成唯一键
    FOREIGN KEY (username) REFERENCES users(username)                  -- username 外键引用 users 表
);



CREATE TABLE bloodOxygen(
    id int(11) REFERENCES users(user_id),
    bloodOxygen float,
    setDate DATE,
    PRIMARY KEY(id, setDate)
);

CREATE TABLE bloodPressure(
    id int(11) REFERENCES users(user_id),
    bloodPressure int(11),
    setDate DATE,
    PRIMARY KEY(id, setDate)
);

CREATE TABLE bloodSugar(
    id int(11) REFERENCES users(user_id),
    bloodSugar float,
    setDate DATE,
    PRIMARY KEY(id, setDate)
);

CREATE TABLE heartRate(
    id int(11) REFERENCES users(user_id),
    heartRate int(11),
    setDate DATE,
    PRIMARY KEY(id, setDate)
);

CREATE TABLE height(
    id int(11) REFERENCES users(user_id),
    height float,
    setDate DATE,
    PRIMARY KEY(id, setDate)
);



CREATE TABLE steps(
    id int(11) REFERENCES users(user_id),
    steps int(11),
    setDate DATE,
    PRIMARY KEY(id, setDate)
);


CREATE TABLE weight(
    id int(11) REFERENCES users(user_id),
    weight float,
    setDate DATE,
    PRIMARY KEY(id, setDate)
);