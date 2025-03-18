package com.org.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {

    // 加密密码方法
    public static String hashPassword(String password) {
        // 生成盐值（salt）
        String salt = BCrypt.gensalt();
        // 使用盐值和密码生成加密后的哈希值
        return BCrypt.hashpw(password, salt);
    }

    // 验证密码是否正确
    public static boolean verifyPassword(String password, String hashedPassword) {
        // 使用BCrypt库提供的方法验证密码和存储的哈希密码是否匹配
        return BCrypt.checkpw(password, hashedPassword);
    }
}
