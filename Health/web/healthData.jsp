<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>健康数据管理</title>
    <link rel='stylesheet' type='text/css' href='styles/main.css'>

</head>
<body>

<!-- 标题区域 -->
<header class="header">
    <h1>健康数据管理</h1>
    <!-- 登出按钮 -->
    <div class="logout-container">
        <a href="index.jsp" class="logout-btn">返回主页面</a>
    </div>
</header>

<!-- 导航栏 -->
<nav class="navbar">
    <button onclick="loadIframe('indexHeight.jsp')">身高</button>
    <button onclick="loadIframe('indexWeight.jsp')">体重</button>
    <button onclick="loadIframe('indexSteps.jsp')">步数</button>
    <button onclick="loadIframe('indexBloodSugar.jsp')">血糖</button>
    <button onclick="loadIframe('indexBloodOxygen.jsp')">血氧</button>
    <button onclick="loadIframe('indexBloodPressure.jsp')">血压</button>
    <button onclick="loadIframe('indexHeartRate.jsp')">心率</button>
</nav>

<main class="content">
    <iframe id="iframeContent" src="indexBloodPressure.jsp" frameborder="0"></iframe>
</main>

<script>
    function loadIframe(page) {
        document.getElementById('iframeContent').src = page;
    }
</script>

</body>
</html>
