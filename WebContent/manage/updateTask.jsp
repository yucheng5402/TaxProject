<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>任务录入</title>
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
</head>
<body>
<form id="addForm">
<div class="container">
    <div class="content">
        <div title="纳税人信息" data-options="closable:false" class="basic-info">
            <div class="column"><span class="current">纳税人基本信息</span></div>
            <table class="kv-table">
                <tbody>
                <tr>
                    <td class="kv-label">纳税人识别号</td>
                    <td class="kv-content">${payer.payerCode }
                    <input type="hidden" name="payerId" value="${payer.id }"
                                               ></td>
                    <td class="kv-label">纳税人名称</td>
                    <td class="kv-content">${payer.payerName}</td>
                    <td class="kv-label">生产经营地址</td>
                    <td class="kv-content">${payer.bizAddress }</td>
                </tr>
                <tr>
                    <td class="kv-label">所属税务机关</td>
                    <td class="kv-content">${organ.organName }</td>
                    <td class="kv-label">行业</td>
                    <td class="kv-content">${industry.industryName }</td>
                    <td class="kv-label">经营范围</td>
                    <td class="kv-content">${payer.bizScope }</td>
                </tr>
                <tr>
                    <td class="kv-label">票种核定</td>
                    <td class="kv-content">${payer.invoiceType }</td>
                    <td class="kv-label">法人代表人</td>
                    <td class="kv-content">${payer.legalPerson }</td>
                    <td class="kv-label">法人身份证号</td>
                    <td class="kv-content">${payer.legalIdCard }</td>
                </tr>
                <tr>
                    <td class="kv-label">主管财务</td>
                    <td class="kv-content">${payer.finaceName }</td>
                    <td class="kv-label">财务身份证号</td>
                    <td class="kv-content">${payer.finaceIdCard }</td>
                    <td class="kv-label">税收管理员</td>
                    <td class="kv-content">${payer.taxerName }</td>
                </tr>
                <tr>
                    <td class="kv-label">办税人员</td>
                    <td class="kv-content">${payer.taxerName }</td>
                    <td class="kv-label">录入日期</td>
                    <td class="kv-content">${payer.recordDate }</td>
                    <td class="kv-label">录入人</td>
                    <td class="kv-content">${user1.username}</td>
                </tr>
                </tbody>
            </table>
            <div class="column"><span class="current">任务信息</span></div>
            <table class="kv-table">
                <tbody>
                <tr>
                    <td class="kv-label">任务名称</td>
                    <td class="kv-content">
                    <input type="hidden" name="id" value="${source.id }">
                    <input type="text" name="taskName" placeholder="请输入任务名称" value="${source.taskName }"></td>
                    <td class="kv-label">下达部门</td>
                    <td class="kv-content">
                    <input type="text" name="organName" value="${organ.organName}" readonly="readonly"></td>
                    <td class="kv-label">批准人</td>
                    <td class="kv-content">
                    <select name="approverId" class="easyui-validatebox" validType="choose">
                                <option value="-1">请选择批准人</option>
                            </select></td>
                
                </tr>
                <tr>
                    
                    <td class="kv-label">执行人</td>
                    <td class="kv-content">
                    <select name="executeId" class="easyui-validatebox" validType="choose">
                                <option value="-1">请选择执行人</option>
                            </select></td>
                    <td class="kv-label">执行时间</td>
                    <td class="kv-content">
                    <input type="date" name="executeTime" required="true" 
                    value="${source.executeTime }" style="width: 220px;height: 30px"></td>
                    <td class="kv-label">任务执行情况</td>
                    <td class="kv-content">
                        <textarea rows="3" style="width: 90%;" name="taskState" >${source.taskState }</textarea>
                    </td>
                </tr>
                <tr>
                <td class="kv-label">调查结论和意见</td>
                    <td class="kv-content" colspan="3">
                        <textarea rows="3" style="width: 90%;" name="idea"></textarea>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="btn-selection">
				<a href="javascript:void(0);" iconcls="icon-ok" class="easyui-linkbutton save-btn"
					data-options="selected:true">修改</a>
				 <a href="javascript:void(0);"
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
$.post("getTaxer.do",{},function(data){
	var industry = $("select[name='approverId']")
	$.each(data,function(index, val){
		industry.append("<option value='"+val.id+"'>"+val.taxerName+"</option>")
	})
	
$("select:eq(0)").val('${source.approverId }')
},"json");
$.post("getTaxer.do",{},function(data){
     var industry = $("select[name='executeId']")
     $.each(data,function(index, val){
	  industry.append("<option value='"+val.id+"'>"+val.taxerName+"</option>")
     })
    
$("select:eq(1)").val('${source.executeId }')
},"json");

$("a:eq(1)").bind("click", function() {
	$("#addForm").form('reset')
})

$("a:eq(0)").bind("click", function() {
			var state = $("#addForm").form('validate');
			if(state){
				
			$.post("updateTask.do",$("form").serialize(), function(result) {
					if (result.success) {
						$.messager.alert("操作提示", "修改成功", "info", function() {
							//window.location.href = "manage/listTaxer.jsp"
							parent.$("#topWindow").window({closed:true})
						});
					} else {
						$.messager.alert("操作提示", "修改失败", "error", function() {
							//window.location.href = "manage/listTaxer.jsp"
							parent.$("#topWindow").window({closed:true})
						});
					}
			}, "json");
			}
		})
</script>
</html>
