<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String message = request.getParameter("message");
%>
<html>
<head>
    <title>血糖</title>  <!-- 改! -->
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
        <h2>血糖数据</h2>  <!-- 改! -->
        <jsp:include page="exhibitBloodSugar.jsp" />  <!-- 改! -->
    </div>
    <div class="panel">
        <h2>记录今天的数据</h2>
        <jsp:include page="addBloodSugar.jsp" />  <!-- 改! -->
    </div>
    <div class="panel">
        <h2>历史数据</h2>
        <jsp:include page="searchBloodSugar.jsp" />  <!-- 改! -->
    </div>

</div>
</body>
</html>
