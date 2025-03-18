<%@ page import="com.org.vo.Target" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>目标查询结果</title>
    <link rel="stylesheet" type="text/css" href="styles/target.css">
</head>
<body>
<div class="container">
    <h1>目标查询结果</h1>

    <%
        // 获取查询的目标列表
        List<Target> targets = (List<Target>) request.getAttribute("targets");

        if (targets != null && !targets.isEmpty()) {
            for (Target target : targets) {
    %>
    <div>
        <p><strong>目标 ID：</strong><%= target.getTargetId() %></p>
        <p><strong>关注指标：</strong><%= target.getFocus() %></p>
        <p><strong>改善方式：</strong><%= target.getWay() %></p>
        <p><strong>创建时间：</strong><%= target.getCreatedAt() %></p>
        <p><strong>目标持续时间：</strong><%= target.getDeadline() %></p>
        <hr>
    </div>
    <%
        }
    } else {
    %>
    <p>没有找到目标信息。</p>
    <%
        }
    %>

    <!-- 提供查询目标的表单 -->
    <h2>查询目标</h2>
    <form action="SearchTargetServlet" method="get">
        <label for="id">输入目标 ID 查询：</label>
        <input type="number" id="id" name="id">
        <button type="submit">查询</button>
    </form>
</div>

<!-- 返回按钮 -->
<button class="top-right" onclick="window.location.href='index.jsp'">返回首页</button>

</body>
</html>
