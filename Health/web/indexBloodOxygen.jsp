<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String message = request.getParameter("message");
%>
<html>
<head>
    <title>血氧</title>  <!-- 改! -->
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
        <h2>血氧数据</h2>  <!-- 改! -->
        <jsp:include page="exhibitBloodOxygen.jsp" />  <!-- 改! -->
    </div>
    <div class="panel">
        <h2>记录今天的数据</h2>
        <jsp:include page="addBloodOxygen.jsp" />  <!-- 改! -->
    </div>
    <div class="panel">
        <h2>历史数据</h2>
        <jsp:include page="searchBloodOxygen.jsp" />  <!-- 改! -->
    </div>

</div>
</body>
</html>
