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
			<div title="纳税人信息" data-options="closable:false" class="basic-info">
				<div class="column">
					<span class="current">添加办税人信息</span>
				</div>
				<table class="kv-table">
					<tbody>
						<tr>
							<td class="kv-label">办税专员编号</td>
							<td class="kv-content"><input type="text" name="taxerCode"
								placeholder="纳税人识别号" class="easyui-validatebox" data-options="required:true"><span></span></td>
							<td class="kv-label">办税专员姓名</td>
							<td class="kv-content"><input type="text" name="taxerName"
								placeholder="纳税人名称" class="easyui-validatebox" data-options="required:true"><span></span></td>
						</tr>
						<tr>
							<td class="kv-label">手机号</td>
							<td class="kv-content"><input type="text" name="mobile"
								placeholder="手机号" class="easyui-validatebox" data-options="required:true"><span></span></td>
							<td class="kv-label">地址</td>
							<td class="kv-content"><input type="text" name="address"
								placeholder="地址" class="easyui-validatebox" data-options="required:true"><span></span></td>
						</tr>
						<tr>
							<td class="kv-label">邮箱</td>
							<td class="kv-content"><input type="text" name="email"
								placeholder="邮箱" class="easyui-validatebox" data-options="required:true,validType:'email'"><span></span></td>

							<td class="kv-label">性别</td>
							<td class="kv-content">
							<select name="sex" style="width: 214px;height: 39px"  class="easyui-validatebox" validType="choose">
									<option value="-1">请选择</option>
									<option value="男">男</option>
									<option value="女">女</option>
							</select><span></span></td>

						</tr>
						<tr>
							<td class="kv-label">生日</td>
							<td class="kv-content"><input class="easyui-validatebox" data-options="required:true"  type="date" name="birthday"
								placeholder="生日" style="width: 210px;height: 30px"><span></span></td>
							<td class="kv-label">所属税务机关</td>
							<td class="kv-content"><select name="taxOrganId"
								id="selectOrgan" style="width: 214px;height: 39px" class="easyui-validatebox" validType="choose">
									<option value="-1">所属税务机关</option>
							</select><span></span></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn-selection">
				<a href="javascript:void(0);" iconcls="icon-ok" class="easyui-linkbutton save-btn"
					data-options="selected:true">保存</a> <a href="javascript:void(0);"
					iconcls="icon-reload" class="easyui-linkbutton reset-btn" data-options="selected:true">重置</a>
			</div>
		</div>
	</div>
</form>
</body>
<script type="text/javascript">
$.extend($.fn.validatebox.defaults.rules, {
    choose: {
		validator: function(value,param){
			return value != -1;
		},
		message: '请选择'
    }
});
	$(function() {

		$.post("getOrganServlet.do", {}, function(result) {
			var organ = $("#selectOrgan")
			$.each(result, function(index, val) {
				organ.append("<option value='"+val.id+"'>" + val.organName
						+ "</option>")
			})
		}, "json")

		$("a:eq(1)").bind("click", function() {
			$("#addForm").form('reset')
		})
		$("a:eq(0)").bind("click", function() {
			var state = $("#addForm").form('validate');
			if(state){
			$.post("addTaxer",$("form").serialize(), function(result) {
				if (result.success) {
					$.messager.alert("操作提示", "保存成功", "info", function() {
						//window.location.href = "manage/listTaxer.jsp"
						parent.$("#topWindow").window({closed:true})
					});
				} else {
					$.messager.alert("操作提示", "保存失败", "error", function() {
						//window.location.href = "manage/listTaxer.jsp"
						parent.$("#topWindow").window({closed:true})
					});
				}
			}, "json");
			}
		})
	})
</script>
</html>