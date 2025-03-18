<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="com.org.factory.DAOFactory" %>
<%@ page import="com.org.vo.BloodPressure" %>
<%@ page import="java.util.*" %>
<%@ page import="com.org.vo.HealthData" %>
<%@ page import="com.org.vo.Steps" %>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <script src="jquery/jquery-1.9.1.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>
  <title>权限管理</title>
  <script language="javascript">
    // 注销
    function logout() {
      window.location.href = "${ctx}/login.jsp";
    }
  </script>
</head>
<body>
<div class="container-fluid" style="padding-left: 0px; padding-right: 0px">
  <!-- 顶部Logo定义开始 -->
  <div class="row-fluid">
    <jsp:include page="north.jsp" flush="true"/>
  </div>
  <!-- 顶部Logo定义结束 -->
  <div class="row-fluid">
    <!-- 左边导航条定义开始  -->
    <jsp:include page="left.jsp" flush="true"/>
    <!-- 左边导航条定义结束-->
    <div class="col-md-10" style="margin-top: 20px">
      <!-- 使用Bootstrap栅格系统横向排列 -->
      <div class="row" style="display: flex; gap: 20px;">
        <!-- 第一个面板 -->
        <div class="col-md-6">
          <div class="panel">
            <div class="panel-heading">
              <h3 class="panel-title">步数数据</h3>
            </div>
            <div class="panel-body">
              <!-- 步数数据展示内容开始 -->
              <%
                int id = (Integer) session.getAttribute("user_id");
                ArrayList<HealthData> record1 = DAOFactory.getIStepsDAOInstance().dataTrend(id);

                Steps data0 = null;
                try {
                  data0 = (Steps)record1.get(0);
                } catch (Exception ex) {
                  data0 = new Steps();
                  ex.printStackTrace();
                }
                Iterator<HealthData> iter1 = record1.iterator();

                ArrayList<Date> dates1 = new ArrayList<>();
                ArrayList<Integer> values1 = new ArrayList<>();

                while (iter1.hasNext()) {
                  Steps data = (Steps)iter1.next();
                  dates1.add(data.getDate());
                  values1.add((int)data.getData());
                }
              %>

              <div class="content" style="text-align: left;">
                <h3>最新记录</h3>
                步&nbsp&nbsp数: <%=(int)data0.getData()%> 步
                <br/>
                记录时间: <%=data0.getDate()%>
                <br/>
              </div>

              <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
              <script src="scripts/plotChart.js"></script>

              <h3>健康数据趋势</h3>
              <canvas id="healthDataChart1" width="400" height="200"></canvas>
              <script>
                // 获取JSP中传递的数据
                var dates1 = <%= new com.google.gson.Gson().toJson(dates1) %>;
                var values1 = <%= new com.google.gson.Gson().toJson(values1) %>;

                // 调用通用函数绘制图表
                drawLineChart('healthDataChart1', dates1, values1, '步数', '日期', '值');
              </script>
              <!-- 步数数据展示内容结束 -->
            </div>
          </div>
        </div>

        <!-- 第二个面板 -->
        <div class="col-md-6">
          <div class="panel">
            <div class="panel-heading">
              <h3 class="panel-title">血压数据</h3>
            </div>
            <div class="panel-body">
              <!-- 血压数据展示内容开始 -->
              <%

                ArrayList<HealthData> record2 = DAOFactory.getIBloodDAOInstance().dataTrend(id);

                BloodPressure data2 = null;
                try {
                  data2 = (BloodPressure)record2.get(0);
                } catch (Exception ex) {
                  data2 = new BloodPressure();
                  ex.printStackTrace();
                }
                Iterator<HealthData> iter2 = record2.iterator();

                ArrayList<Date> dates2 = new ArrayList<>();
                ArrayList<Integer> values2 = new ArrayList<>();

                while (iter2.hasNext()) {
                  BloodPressure data = (BloodPressure)iter2.next();
                  dates2.add(data.getDate());
                  values2.add((int)data.getData());
                }
              %>

              <div class="content" style="text-align: left;">
                <h3>最新记录</h3>
                血&nbsp&nbsp压: <%=(int)data2.getData()%> mmHg
                <br/>
                记录时间: <%=data2.getDate()%>
                <br/>
              </div>

              <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
              <script src="scripts/plotChart.js"></script>

              <h3>健康数据趋势</h3>
              <canvas id="healthDataChart2" width="400" height="200"></canvas>
              <script>
                // 获取JSP中传递的数据
                var dates2 = <%= new com.google.gson.Gson().toJson(dates2) %>;
                var values2 = <%= new com.google.gson.Gson().toJson(values2) %>;

                // 调用通用函数绘制图表
                drawLineChart('healthDataChart2', dates2, values2, '血压', '日期', '值');
              </script>
              <!-- 血压数据展示内容结束 -->
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>

