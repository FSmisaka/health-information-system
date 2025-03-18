<%@ page import="com.org.factory.DAOFactory" %>
<%@ page import="java.util.*" %>
<%@ page import="com.org.vo.HealthData" %>
<%@ page import="com.org.vo.HeartRate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示heartRate</title>
    <link rel='stylesheet' type='text/css' href='styles/main.css'>

</head>
<body>
<%
    // int id = Integer.parseInt((String)session.getAttribute("user"));
    int id = (Integer) session.getAttribute("user_id");
    ArrayList<HealthData> record = DAOFactory.getIHeartRateDAOInstance().dataTrend(id);

    HeartRate data0 = null;
    try {
        data0 = (HeartRate) record.get(0);
    } catch (Exception ex) {
        data0 = new HeartRate();
        ex.printStackTrace();
    }
    Iterator<HealthData> iter = record.iterator();

    ArrayList<Date> dates = new ArrayList<>();
    ArrayList<Integer> values = new ArrayList<>();

    while (iter.hasNext()) {
        HeartRate data = (HeartRate) iter.next();
        dates.add(data.getDate());
        values.add((int)data.getData());
    }
%>

<div class="content" style="text-align: left;">
    <h3>最新记录</h3>
    心&nbsp&nbsp率: <%=(int)data0.getData()%> BPM
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
    drawLineChart('healthDataChart', dates, values, '心率', '日期', '值');
</script>


</body>
</html>
