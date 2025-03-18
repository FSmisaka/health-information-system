USE health_information_system;

-- 插入示例用户数据
INSERT INTO users (username, password, avatar, name, birthday, gender, blood_type, contact_email, contact_phone)
VALUES
    ('john_doe', '123', 'avatar_path_1.jpg', 'John Doe', '1985-05-15', 'M', 'O', 'john@example.com', '1234567890'),
    ('jane_smith', '123', 'avatar_path_2.jpg', 'Jane Smith', '1990-10-25', 'F', 'A', 'jane@example.com', '0987654321');

-- 由于先创建john_doe用户，所以id=1是john的数据
INSERT INTO bloodPressure (id, bloodPressure, setDate) VALUES
                                                           (1, 120, '2023-10-25'),
                                                           (1, 125, '2023-11-25'),
                                                           (1, 130, '2023-12-25'),
                                                           (1, 135, '2024-1-25'),
                                                           (1, 140, '2024-2-25');

INSERT INTO height (id, height, setDate) VALUES
                                             (1, 169.5, '2023-10-25'),
                                             (1, 171.0, '2023-11-25'),
                                             (1, 172.2, '2023-12-25'),
                                             (1, 172.5, '2024-1-25'),
                                             (1, 172.5, '2024-2-25');

INSERT INTO weight (id, weight, setDate) VALUES
                                             (1, 70.5, '2023-10-25'),
                                             (1, 71.0, '2023-11-25'),
                                             (1, 74.8, '2023-12-25'),
                                             (1, 78.2, '2024-1-25'),
                                             (1, 86.9, '2024-2-25');

INSERT INTO steps (id, steps, setDate) VALUES
                                           (2, 5000, '2023-10-25'),
                                           (2, 6000, '2023-11-25'),
                                           (2, 7000, '2023-12-25'),
                                           (2, 8000, '2024-1-25'),
                                           (2, 9000, '2024-2-25');

INSERT INTO steps (id, steps, setDate) VALUES
                                           (1, 5000, '2023-10-25'),
                                           (1, 9000, '2023-11-25'),
                                           (1, 7000, '2023-12-25'),
                                           (1, 4000, '2024-1-25'),
                                           (1, 9000, '2024-2-25');


-- 插入血氧数据
INSERT INTO bloodOxygen (id, bloodOxygen, setDate) VALUES
                                                       (1, 98.5, '2023-10-25'),
                                                       (1, 97.8, '2023-11-25'),
                                                       (1, 98.2, '2023-12-25'),
                                                       (1, 97.6, '2024-01-25'),
                                                       (1, 98.0, '2024-02-25');

-- 插入血糖数据
INSERT INTO bloodSugar (id, bloodSugar, setDate) VALUES
                                                     (1, 5.2, '2023-10-25'),
                                                     (1, 5.0, '2023-11-25'),
                                                     (1, 5.1, '2023-12-25'),
                                                     (1, 5.3, '2024-01-25'),
                                                     (1, 5.0, '2024-02-25');

-- 插入心率数据
INSERT INTO heartRate (id, heartRate, setDate) VALUES
                                                   (1, 72, '2023-10-25'),
                                                   (1, 75, '2023-11-25'),
                                                   (1, 73, '2023-12-25'),
                                                   (1, 70, '2024-01-25'),
                                                   (1, 74, '2024-02-25');
