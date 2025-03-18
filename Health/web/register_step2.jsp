<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册 - 步骤2</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="styles/register_step2.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>

<div class="container">
    <h2>填写健康信息</h2>
    <form action="RegisterStep2Servlet" method="POST">
        <!-- 身高 -->
        <div class="mb-3">
            <label for="height" class="form-label">身高 (cm)</label>
            <input type="number" class="form-control" id="height" name="height" required>
        </div>

        <!-- 体重 -->
        <div class="mb-3">
            <label for="weight" class="form-label">体重 (kg)</label>
            <input type="number" class="form-control" id="weight" name="weight" required>
        </div>

        <!-- 下一步按钮 -->
        <button type="submit" class="btn">下一步</button>
    </form>

    <!-- 返回按钮 -->
    <a href="register_step1.jsp" class="back-btn">返回上一步</a>
</div>

</body>
</html>
