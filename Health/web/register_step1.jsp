<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册 - 步骤1</title>

    <!-- 引入 Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="styles/register.css" rel="stylesheet"> <!-- 引入自定义CSS -->

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
<div class="container">
    <h2 style="color: #007bff; font-size: 24px; text-align: center; margin-bottom: 30px;">填写基本信息</h2>
    <form action="RegisterStep1Servlet" method="POST">
        <!-- 账号 -->
        <div class="mb-3">
            <label for="username" class="form-label">账号</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="请输入账号" required>
        </div>
        <!-- 密码 -->
        <div class="mb-3">
            <label for="password" class="form-label">密码</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码" required>
        </div>
        <!-- 姓名 -->
        <div class="mb-3">
            <label for="name" class="form-label">姓名</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名" required>
        </div>

        <!-- 生日 -->
        <div class="mb-3">
            <label for="birthdate" class="form-label">生日</label>
            <input type="date" class="form-control" id="birthdate" name="birthdate" required>
        </div>

        <!-- 性别 -->
        <div class="mb-3">
            <label class="form-label">性别</label>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="male" value="male" required>
                <label class="form-check-label" for="male">男</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="female" value="female">
                <label class="form-check-label" for="female">女</label>
            </div>
        </div>

        <!-- 血型 -->
        <div class="mb-3">
            <label for="bloodtype" class="form-label">血型</label>
            <select class="form-select" id="bloodtype" name="bloodtype" required>
                <option value="" disabled selected>请选择血型</option>
                <option value="A">A型</option>
                <option value="B">B型</option>
                <option value="AB">AB型</option>
                <option value="O">O型</option>
            </select>
        </div>

        <!-- 电话 -->
        <div class="mb-3">
            <label for="phone" class="form-label">电话</label>
            <input type="text" class="form-control" id="phone" name="phone" placeholder="请输入电话" required>
        </div>

        <!-- 邮箱 -->
        <div class="mb-3">
            <label for="email" class="form-label">邮箱</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="请输入邮箱" required>
        </div>

        <!-- 头像上传 -->
        <div class="mb-3">
            <label for="avatar" class="form-label">头像</label>
            <input type="file" class="form-control" id="avatar" name="avatar">
        </div>

        <!-- 健康提示框 -->
        <div id="health-tip" class="alert alert-info" role="alert">
            <strong>健康提示:</strong> 填写信息后会显示相关的健康提示。
        </div>

        <!-- 下一步按钮 -->
        <button type="submit" class="btn btn-primary">下一步</button>
    </form>

    <!-- 返回按钮 -->
    <a href="login.jsp" class="btn btn-secondary mt-3">返回首页</a>
</div>

</body>

</html>
