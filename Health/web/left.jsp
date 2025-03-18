<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<div class="col-md-2" style="margin-top: 20px;">
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-12">
				<div class="panel-group" id="accordion-861724">
					<!-- 目标管理 -->
					<div class="panel panel-default">
						<div class="panel-heading">
							<a class="accordion-toggle" data-toggle="collapse"
							   data-parent="#accordion-861724" href="#accordion-target-management">
								目标管理
							</a>
						</div>
						<div id="accordion-target-management" class="panel-collapse collapse in">
							<div class="panel-body">
								<a href="SearchTargetServlet">查询目标</a>
							</div>
							<div class="panel-body">
								<a href="AddTargetServlet">新增目标</a>
							</div>
						</div>
					</div>
					<!-- 建议管理 -->
					<div class="panel panel-default">
						<div class="panel-heading">
							<a class="accordion-toggle" data-toggle="collapse"
							   data-parent="#accordion-861724" href="#accordion-advice-management">
								建议管理
							</a>
						</div>
						<div id="accordion-advice-management" class="panel-collapse collapse">
							<div class="panel-body">
								<a href="GetAdviceServlet">获取建议</a>
							</div>
							<div class="panel-body">
								<a href="chat.jsp">个性化建议</a>
							</div>
						</div>
					</div>
					<!-- 健康数据 -->
					<div class="panel panel-default">
						<div class="panel-heading">
							<a class="accordion-toggle" data-toggle="collapse"
							   data-parent="#accordion-861724" href="#accordion-health-data">
								健康数据
							</a>
						</div>
						<div id="accordion-health-data" class="panel-collapse collapse">
							<div class="panel-body">
								<a href="healthData.jsp">健康数据</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

