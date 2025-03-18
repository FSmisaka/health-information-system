<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Chat with AI</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/chat.css">
</head>
<body>
<div class="container">
  <div class="top-right">
    <a href="index.jsp" class="back-button">返回首页</a>
  </div>
  <h1>Chat with AI</h1>
  <label for="model-select">选择模型：</label>
  <select id="model-select">
    <option value="chat1">ChatGPT-4</option>
    <option value="chat0">DeepSeekV3</option>
  </select>
  <textarea id="user-question" placeholder="请输入您的问题..."></textarea>
  <button id="send-button">发送</button>
  <div id="response"></div>
</div>
<script src="${pageContext.request.contextPath}/scripts/script.js"></script>
</body>
</html>
