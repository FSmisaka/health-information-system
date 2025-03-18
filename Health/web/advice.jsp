<%@ page import="com.org.dao.TargetDAO" %>
<%@ page import="com.org.factory.DAOFactory1" %>
<%@ page import="com.org.vo.Target" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
  <title>健康建议</title>
  <link rel="stylesheet" type="text/css" href="styles/advice.css">
</head>
<body>
<h1 style="color: #f0f8ff; text-shadow: 8px 8px 16px rgba(0, 0, 0, 0.3);">最近目标查询结果</h1>

<%
  Target recentTarget = null;
  try {
    String username = (String) session.getAttribute("username");
    TargetDAO targetDAO = DAOFactory1.getTargetDAO();
    List<Target> targets = targetDAO.getRecentTargets(username, 1);
    if (!targets.isEmpty()) {
      recentTarget = targets.get(0);
    }
  } catch (Exception e) {
    out.println("<p>查询目标时发生错误：" + e.getMessage() + "</p>");
  }

  if (recentTarget != null) {
%>
<div>
  <p><strong>目标 ID：</strong><%= recentTarget.getTargetId() %></p>
  <p><strong>关注指标：</strong><%= recentTarget.getFocus() %></p>
  <p><strong>改善方式：</strong><%= recentTarget.getWay() %></p>
  <p><strong>创建时间：</strong><%= recentTarget.getCreatedAt() %></p>
  <p><strong>目标持续时间：</strong><%= recentTarget.getDeadline() %></p>
</div>
<%
} else {
%>
<p>没有找到最近的目标信息。</p>
<%
  }
%>

<h1 style="color: #f0f8ff; text-shadow: 8px 8px 16px rgba(0, 0, 0, 0.3);">健康建议</h1>
<div>
  <p>${advice}</p>
</div>

<div>
  <button onclick="window.location.href='index.jsp'">返回首页</button>
</div>

</body>
</html>
