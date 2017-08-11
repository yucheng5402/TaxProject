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
                    <td class="kv-content">${source.taskName }</td>
                    <td class="kv-label">下达部门</td>
                    <td class="kv-content">${organ.organName }</td>
                    <td class="kv-label">批准人</td>
                    <td class="kv-content">${taxer1.taxerName }</td>
                </tr>
                <tr>
                    <td class="kv-label">执行人</td>
                    <td class="kv-content">${taxer2.taxerName }</td>
                    <td class="kv-label">执行时间</td>
                    <td class="kv-content">${source.executeTime }</td>
                    <td class="kv-label">任务执行情况</td>
                    <td class="kv-content">
                        <textarea rows="3" style="width: 90%;" name="taskState" >${source.taskState }</textarea>
                    </td>
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
</body>
<script type="text/javascript">
$("a:eq(0)").bind("click", function() {
	parent.$("#topWindow").window({closed:true})
})
</script>
</html>
