<%@ page import="com.org.factory.DAOFactory" %>
<%@ page import="java.util.*" %>
<%@ page import="com.org.vo.HealthData" %>
<%@ page import="com.org.vo.Weight" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示weight</title>  <!-- 改 -->
    <link rel='stylesheet' type='text/css' href='styles/main.css'>

</head>
<body>
<%
    // int id = Integer.parseInt((String)session.getAttribute("user"));
    int id = (Integer) session.getAttribute("user_id");
    ArrayList<HealthData> record = DAOFactory.getIWeightDAOInstance().dataTrend(id);  //改

    Weight data0 = null;  //改
    try {
        data0 = (Weight) record.get(0);  //改
    } catch (Exception ex) {
        data0 = new Weight();  //改
        ex.printStackTrace();
    }
    Iterator<HealthData> iter = record.iterator();

    ArrayList<Date> dates = new ArrayList<>();
    ArrayList<Double> values = new ArrayList<>();  //改

    while (iter.hasNext()) {
        Weight data = (Weight)iter.next();  //改
        dates.add(data.getDate());
        values.add(data.getData());
    }
%>

<div class="content" style="text-align: left;">
    <h3>最新记录</h3>
    体&nbsp&nbsp重: <%=data0.getData()%> kg <!-- 改 -->
    <br/>
    记录时间: <%=data0.getDate()%>
    <br/>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="scripts/plotChart.js"></script>

<h3>健康数据趋势</h3>
<canvas id="healthDataChart" width="400" height="200"></canvas>
<script>
    // 获取JSP中传递的数据
    var dates = <%= new com.google.gson.Gson().toJson(dates) %>;
    var values = <%= new com.google.gson.Gson().toJson(values) %>;

    // 调用通用函数绘制图表
    drawLineChart('healthDataChart', dates, values, '体重', '日期', '值');  <!-- 改 -->
</script>


</body>
</html>
