<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String message = request.getParameter("message");
%>
<html>
<head>
    <title>心率</title> <!-- 改! -->
    <link rel='stylesheet' type='text/css' href='styles/indexPage.css'>
    <script src="scripts/exceptionAlert.js"></script>
    <script>
        const message = "<%= message %>";
        showMessage(message);
    </script>

</head>

<body>
<div class="dashboard">
    <div class="panel">
        <h2>心率数据</h2> <!-- 改! -->
        <jsp:include page="exhibitHeartRate.jsp" /> <!-- 改! -->
    </div>
    <div class="panel">
        <h2>记录今天的数据</h2>
        <jsp:include page="addHeartRate.jsp" /> <!-- 改! -->
    </div>
    <div class="panel">
        <h2>历史数据</h2>
        <jsp:include page="searchHeartRate.jsp" /> <!-- 改! -->
    </div>

</div>
</body>
</html>
