package com.org.factory;

import com.org.dao.TargetDAO;
import java.sql.SQLException;

public class DAOFactory1 {
    // 获取 TargetDAO 的实例
    public static TargetDAO getTargetDAO() throws SQLException {
        return new TargetDAO();
    }
}
