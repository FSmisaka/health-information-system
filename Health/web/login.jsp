<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录 - 健康信息系统</title>

    <!-- 引入 Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
    <!-- 引入自定义 CSS -->
    <link rel="stylesheet" href="styles/login.css">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container">
    <div class="login-container">
        <h2>KWX健康信息管理系统</h2>

        <!-- 错误消息提示 -->
        <c:if test="${not empty errorMessage}">
            <div class="error-message">${errorMessage}</div>
        </c:if>

        <!-- 登录表单 -->
        <form action="LoginServlet" method="POST">

            <!-- 用户名输入框 -->
            <div class="form-group">
                <label for="username">用户名</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名" required>
            </div>

            <!-- 密码输入框 -->
            <div class="form-group">
                <label for="password">密码</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码" required>
            </div>

            <!-- 登录按钮 -->
            <button type="submit" class="btn btn-primary">登录</button>

        </form>

        <!-- 注册链接 -->
        <div class="link">
            <p>没有账号？ <a href="register_step1.jsp">点击注册</a></p>
        </div>
    </div>
</div>

</body>
</html>
