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
<form id="updateForm">
	<div class="container">
		<div class="content">
			<div title="个人信息" data-options="closable:false" class="basic-info">
				<div class="column">
					<span class="current">修改密码</span>
				</div>
				<table class="kv-table">
					<tbody>
						<tr>
							<td class="kv-label">原密码</td>
							<td class="kv-content">
							<input type="password" id="pw" name="password" class="easyui-validatebox" required="required" ><span></span></td>
						</tr>
						<tr>
							<td class="kv-label">新密码</td>
							<td class="kv-content">
							<input type="password" id="pwd" name="newPassword" class="easyui-validatebox" required="required" validType="abc['#pw']"></td>
						</tr>
						<tr>
							<td class="kv-label">确认新密码</td>
							<td class="kv-content">
                            <input type="password" name="confirmPassword" class="easyui-validatebox" required="required" validType="equals['#pwd']"></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn-selection">
				<a href="javascript:void(0);" class="easyui-linkbutton save-btn"
					data-options="selected:true" iconcls="icon-ok">确认</a>
				<a href="javascript:void(0);" class="easyui-linkbutton save-btn"
					data-options="selected:true" iconcls="icon-reload">重置</a>
			</div>
		</div>
	</div>
</form>
<script type="text/javascript">

$.extend($.fn.validatebox.defaults.rules, {
    equals: {
		validator: function(value,param){
			return value == $(param[0]).val();
		},
		message: '两次密码输入不一致'
    }
  
});
$.extend($.fn.validatebox.defaults.rules, {
abc: {
    validator: function(value,param){
	return value != $(param[0]).val();
   },
    message: '新密码不能与原密码一样'
  }
});
$("a:eq(0)").bind("click", function() {
	var password = $("input[name='password']").val();
	var newPassword = $("input[name='newPassword']").val();
	var confirmPassword = $("input[name='confirmPassword']").val();
	var state = $("#updateForm").form('validate');
	 if(state){
		 $.post("confirmPasswordServlet",{"password":password},function(result){
				if(result.success){
					$.post("editPasswordServlet",{"newPassword":newPassword},function(result){
						if(result.success){
							 $.messager.alert("操作提示", "修改成功！请重新登录","info",function(){
								 
								  parent.location.href="LogoutServlet"
							 });
						}else{
							alert("修改失败")
						}
					},"json")
				}else{
					$("input[name='password']").next().html("密码错误").css("color","red")
				}
			},"json")
	 }
})
$("a:eq(1)").bind("click", function() {
	$("#updateForm").form('reset');
	 
})
</script>
</body>
</html></html>