<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>设置健康目标</title>
  <link rel="stylesheet" type="text/css" href="styles/target_insert.css">
</head>
<body>
<h1>设置健康目标</h1>
<form action="AddTargetSubmitServlet" method="post">
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
    <button type="submit">提交目标</button>
  </div>
</form>
</body>
</html>
