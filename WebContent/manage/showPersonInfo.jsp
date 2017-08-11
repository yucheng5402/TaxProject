<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>添加办税专员</title>
<link rel="stylesheet" type="text/css" href="static/css/base.css">
<link rel="stylesheet" type="text/css"
	href="static/easyui/uimaker/easyui.css">
<link rel="stylesheet" type="text/css"
	href="static/easyui/uimaker/icon.css">
<link rel="stylesheet" type="text/css" href="static/css/edit.css">
</head>
<script type="text/javascript" src="static/jquery/jquery.min.js"></script>
<script type="text/javascript" src="static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="static/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="static/js/calendar.js"></script>
<script type="text/javascript"></script>
<body>
<form id="addForm">
	<div class="container">
		<div class="content">
			<div title="个人信息" data-options="closable:false" class="basic-info">
				<div class="column">
					<span class="current">个人基本信息</span>
				</div>
				<table class="kv-table">
					<tbody>
						<tr>
							<td class="kv-label">用户员工编号</td>
							<td class="kv-content"><input type="text" name="taxerCode"
								disabled="disabled" value="${user.id }"></td>
							<td class="kv-label">用户权限</td>
							<td class="kv-content">${user.permissionId }</td>
							<td class="kv-label">用户状态</td>
							<td class="kv-content">${user.state}</td>
							
						</tr>
						<tr>
							<td class="kv-label">税务人员工号</td>
							<td class="kv-content">${taxer.taxerCode }</td>
						    <td class="kv-label">税务人员名称</td>
							<td class="kv-content">${taxer.taxerName }</td>

							<td class="kv-label">税务人员电话</td>
							<td class="kv-content">${taxer.mobile }</td>
						
						</tr>
						<tr>
							
							<td class="kv-label">地址</td>
							<td class="kv-content">${taxer.address }</td>
							<td class="kv-label">性别</td>
							<td class="kv-content">${taxer.sex }</td>
							<td class="kv-label">出生日期</td>
							<td class="kv-content">${taxer.birthday }</td>
							

						</tr>
						<tr>
						<td class="kv-label">邮箱</td>
							<td class="kv-content">${taxer.email }</td>
							<td class="kv-label">税务机关</td>
							<td class="kv-content">${taxer.organName }</td>
							<td class="kv-label">税务状态</td>
							<td class="kv-content">${taxer.state }</td>
						</tr>
						<tr>
						<td class="kv-label">上级主管</td>
							<td class="kv-content">${taxer.mgr }</td>
							<td class="kv-label">系统管理员标志</td>
							<td class="kv-content">${taxer.admin }</td>
							<td class="kv-label">录入时间</td>
							<td class="kv-content">${taxer.recordDate }</td>
							
						
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn-selection">
				<a href="javascript:void(0);" iconcls="icon-cancel" class="easyui-linkbutton save-btn"
					data-options="selected:true">关闭</a>
			</div>
		</div>
	</div>
</form>
<script type="text/javascript">

$("a:eq(0)").bind("click", function() {
	parent.$("#topWindow").window({closed:true})
})
</script>
</body>
</html>