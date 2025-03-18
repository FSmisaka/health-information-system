<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String message = request.getParameter("message");
%>
<html>
<head>
    <title>血压</title>
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
        <h2>血压数据</h2>
        <jsp:include page="exhibitBloodPressure.jsp" />
    </div>
    <div class="panel">
        <h2>记录今天的数据</h2>
        <jsp:include page="addBloodPressure.jsp" />
    </div>
    <div class="panel">
        <h2>历史数据</h2>
        <jsp:include page="searchBloodPressure.jsp" />
    </div>

</div>

</body>
</html>
