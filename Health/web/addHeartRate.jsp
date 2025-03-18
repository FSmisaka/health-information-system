<%@ page import="com.org.controller.PreparedSuggestion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增数据</title>
    <link rel='stylesheet' type='text/css' href='styles/subpage.css'>

</head>
<body>
<h3><%=PreparedSuggestion.createSuggestion("heartRate", 1)%></h3>
<form action="AddHeartRateServlet" method="post">
    <ul>
        <li>
            <label for="ID">用户id: </label>
            <input type="text" id="ID" name="id" value=<%=session.getAttribute("user_id")%> readonly/>
        </li><br/>
        <li>
            <label for="DATA">新增数据: </label>
            <input type="text" id="DATA" name="heartRate"/>
        </li><br/>
        <input type="submit" value="增!"/>
        <input type="reset"/>
    </ul>
</form>
</body>
</html>
