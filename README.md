# KWX健康信息管理系统

## 项目介绍

本健康信息系统采用 Java 11 作为开发语言，采用 IDEA 2019.3.5 作为IDE，并基于 Tomcat 8.5.4 部署。该系统能够展示健康数据的走势图，并依赖以下主要库：

- **JDK 11**
- **Tomcat 8.5.4**：作为应用服务器，用于运行 Java Web 应用。
- **gson-2.8.9.jar**：用于绘制走势图。
- **mysql-connector-java**：用于连接 MySQL 数据库。
- **servlet-api**：用于处理 HTTP 请求和响应。
- **jbcrypt**：用于口令哈希加盐。


## 如何运行项目

### 1. 引入必要的 JAR 包

首先，确保您的开发环境中已包含以下 JAR 文件：

- `gson-2.8.9.jar`：用于处理数据和生成图表。
- `mysql-connector-java`：确保数据库连接正常。
- `servlet-api`：必需的 servlet 库。
- `jbcrypt`：口令哈希加盐。

这些 JAR 文件应该被放置在您的 `lib` 目录下。  

如果出现不能运行的情况，请手动在IDEA `Projects - Modules - Dependencies`中导入对应jar包

### 2. 配置 Tomcat

您需要确保 Tomcat 8.5.4 已正确安装，并且配置了适当的环境变量。您可以通过以下步骤启动 Tomcat：

1. 将项目的 `webapp` 目录下的文件放置到 Tomcat 的 `webapps` 目录中。
2. 启动 Tomcat 服务器，确保 Tomcat 已经运行，并且没有错误。

您也可以采用主流的编译器完成部署，如IDEA

### 3. 修改数据库连接

请修改 `src.dbc.DataConnection` 文件中的数据库连接配置。确保数据库的连接 URL、用户名和密码正确无误。

示例：
```java
package com.org.dbc;

import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/database?useSSL=false&serverTimezone=Asia/Shanghai";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // 获取数据库连接
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 加载数据库驱动
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("数据库连接失败", e);
        }
    }
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
```

### 4. 创建数据库表

在启动项目之前，您需要运行 `createTable.sql` 中提供的 SQL 语句。这些语句将创建项目所需的数据库表，确保数据库结构正确。请根据您的数据库环境执行这些语句以创建基本的表。

### 5. 插入测试数据

为了展示健康数据的走势图，您可以选择执行 `insertTestData.sql` 中的所有 SQL 语句，或者插入更多测试数据。确保数据库中有足够的示例数据，以便在运行项目时能够正确显示图表和数据。

### 6. 启动运行

完成上述步骤后，启动 Tomcat 服务器。在浏览器中访问 [http://localhost:8080](http://localhost:8080) 即可查看系统并展示健康数据的走势图。

## 项目截图

以下是项目运行的一些截图：

![项目截图1](https://github.com/xiongguangpu/shareImage/blob/main/53a702266a03dc61c170cb3ad38a9f5.png?raw=true)

![项目截图2](https://github.com/xiongguangpu/shareImage/blob/main/c0687ffc5896264ac6fce18b4c20a45.png?raw=true)

![项目截图3](https://github.com/xiongguangpu/shareImage/blob/main/9ae1a9befb7ee5e41c2c3c742f41d9e.png?raw=true)



## 联系方式

指导老师：[林浩]

项目成员：[匡昕，王羿珧，熊光蒲]
