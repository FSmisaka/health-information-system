<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册 - 步骤3</title>
    <link href="styles/register_step3.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>

<div class="container">
    <h2>设置健康目标</h2>
    <form action="RegisterStep3Servlet" method="post">
        <div>
            <label for="focus">当前主要关注的健康指标:</label><br>
            <input type="radio" name="focus" value="weight" required> 体重<br>
            <input type="radio" name="focus" value="blood_sugar"> 血糖<br>
            <input type="radio" name="focus" value="blood_pressure"> 血压<br>
        </div>

        <div>
            <label for="way">希望改善的主要方式:</label><br>
            <input type="radio" name="way" value="diet_control" required> 饮食控制<br>
            <input type="radio" name="way" value="increase_exercise"> 增加运动<br>
        </div>

        <div>
            <label for="frequency">期望的健康数据追踪频率:</label><br>
            <input type="radio" name="frequency" value="daily" required> 每日<br>
            <input type="radio" name="frequency" value="weekly"> 每周<br>
            <input type="radio" name="frequency" value="monthly"> 每月<br>
        </div>

        <div>
            <label for="deadline">为健康目标设定多长时间的完成期限?</label><br>
            <input type="radio" name="deadline" value="one_week" required> 一周<br>
            <input type="radio" name="deadline" value="one_month"> 一个月<br>
            <input type="radio" name="deadline" value="three_months"> 三个月<br>
            <input type="radio" name="deadline" value="six_months"> 六个月或更长<br>
        </div>
        <div>
            <button type="submit" class="btn btn-primary">完成注册</button>
        </div>
    </form>

    <!-- 返回按钮 -->
    <a href="register_step2.jsp" class="btn btn-secondary">返回上一步</a>
</div>

</body>
</html>
