<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div class="col-md-12 navbar-inverse">
	<div>
		<div class="navbar-header">
			<a class="navbar-brand" href="#">健康管理系统</a>
		</div>
		<div style="float: right; margin-top: 20px; text-align: center;">
			<font color="#f0ffff"><%= session.getAttribute("username") %></font>
			<a href="LoginOutServlet">安全退出</a>
		</div>
	</div>
</div>