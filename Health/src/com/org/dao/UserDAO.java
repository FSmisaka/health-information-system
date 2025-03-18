package com.org.dao;

import com.org.vo.User;
import com.org.dbc.DatabaseConnection;
import com.org.utils.PasswordUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private final Connection connection;
    public UserDAO() throws SQLException {
        // 初始化数据库连接
        this.connection = DatabaseConnection.getConnection();
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return User对象，包含用户的所有信息
     */
    public User getUserByUsername(String username) {
        User user = null;
        String query = "SELECT * FROM users WHERE username = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    user.setUserId(rs.getInt("user_id"));
                    user.setUsername(rs.getString("username"));
                    user.setName(rs.getString("name"));
                    user.setPassword(rs.getString("password"));
                    user.setGender(rs.getString("gender"));
                    user.setBirthdate(rs.getDate("birthday").toString()); // 修改为 birthday
                    user.setBloodtype(rs.getString("blood_type")); // 修改为 blood_type
                    user.setPhone(rs.getString("contact_phone")); // 修改为 contact_phone
                    user.setEmail(rs.getString("contact_email")); // 修改为 contact_email
                    user.setAvatar(rs.getString("avatar"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    /**
     * 根据用户ID获取用户信息
     *
     * @param userId 用户ID
     * @return User对象，包含用户的所有信息
     */
    public User getUserById(int userId) {
        User user = null;
        String query = "SELECT * FROM users WHERE user_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, userId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    user.setUserId(rs.getInt("user_id"));
                    user.setUsername(rs.getString("username"));
                    user.setName(rs.getString("name"));
                    user.setPassword(rs.getString("password"));
                    user.setGender(rs.getString("gender"));
                    user.setBirthdate(rs.getDate("birthday").toString());
                    user.setBloodtype(rs.getString("blood_type"));
                    user.setPhone(rs.getString("contact_phone"));
                    user.setEmail(rs.getString("contact_email"));
                    user.setAvatar(rs.getString("avatar"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    /**
     * 插入新用户到数据库
     *
     * @param user User对象，包含所有用户信息
     * @return boolean 是否插入成功
     */
    public static boolean saveUser(User user) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO users (username, password, name, birthday, gender, blood_type, contact_phone, contact_email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getBirthdate());
            pstmt.setString(5, user.getGender());
            pstmt.setString(6, user.getBloodtype());
            pstmt.setString(7, user.getPhone());
            pstmt.setString(8, user.getEmail());
            return pstmt.executeUpdate() > 0;  // 如果插入成功，返回true
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }

    /**
     * 用户登录时，验证用户名和密码是否正确
     *
     * @param username 用户名
     * @param password 用户输入的密码
     * @return User对象，包含用户信息，如果密码正确；如果用户名或密码错误，返回null
     */
    public User login(String username, String password) {
        User user = getUserByUsername(username);  // 根据用户名查找用户

        if (user != null) {
            // 比对密码
            if (PasswordUtils.verifyPassword(password, user.getPassword())) {
                return user;  // 登录成功
            }
        }

        return null;  // 登录失败
    }
}

