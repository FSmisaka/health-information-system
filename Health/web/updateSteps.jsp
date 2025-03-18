<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新步数</title>
    <link rel='stylesheet' type='text/css' href='styles/subpage.css'>

</head>
<body>

<%
    int id = (int)request.getAttribute("id");
    int data = (int)request.getAttribute("steps");
    Date date = (Date)request.getAttribute("date");
%>

<form action="DeleteStepsServlet" method="post">
    <h2>删除记录</h2>
    <ul>
        <li>
            <label for="id_del">用户id: </label>
            <input type="text" id="id_del" name="id" value=<%=id%> readonly/>
        </li><br/>
        <li>
            <label for="date_del">记录日期: </label>
            <input type="text" id="date_del" name="date" value=<%=date%> readonly/>
        </li><br/>
    </ul>
    <input type="submit" value="删!" />
</form>

<form action="UpdateStepsServlet" method="post">
    <h2>更新记录</h2>
    <ul>
        <li>
            <label for="id_upd">用户id: </label>
            <input type="text" id="id_upd" name="id" value=<%=id%> readonly/>
        </li><br/>
        <li>
            <label for="date_upd">记录日期: </label>
            <input type="text" id="date_upd" name="date" value=<%=date%> readonly/>
        </li><br/>
        <li>
            <label for="DATA">步&nbsp&nbsp数: </label>
            <input type="text" id="DATA" name="steps" value=<%=data%> />
        </li><br/>
    </ul>
    <input type="submit" value="更新" />
    <input type="reset" />
</form>
</body>
</html>
