<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>步数历史</title>
    <link rel='stylesheet' type='text/css' href='styles/subpage.css'>

</head>
<body>

<h3>步数历史</h3>
<form action="SearchStepsServlet" method="post">
    <ul>
        <li>
            <label for="ID">用户id: </label>
            <input type="text" id="ID" name="id" value=<%=session.getAttribute("user_id")%> readonly/>
        </li><br/>
        <li>
            <label for="DATE">日期: </label>
            <input type="date" id="DATE" name="date" value="<%=java.time.LocalDate.now()%>"/>
        </li><br/>
        <input type="submit" value="查!"/>
        <input type="reset"/>
    </ul>
</form>
</body>
</html>
