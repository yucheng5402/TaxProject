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
    <link rel="stylesheet" type="text/css" href="static/css/base.css" >
    <link rel="stylesheet" type="text/css" href="static/easyui/uimaker/easyui.css">
    <link rel="stylesheet" type="text/css" href="static/easyui/uimaker/icon.css">
    <link rel="stylesheet" type="text/css" href="static/css/edit.css">
    
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
                    <td class="kv-content"><input type="text" name="payerCode" value="${payer.payerCode }"
                                                  placeholder="请输入纳税人识别号，获取纳税人信息">
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
                    <td class="kv-content"><input type="text" name="taskName" placeholder="请输入任务名称"></td>
                    <td class="kv-label">下达部门</td>
                    <td class="kv-content">
                   <!--  <select name="subOrganId" class="easyui-validatebox" validType="choose">
                                <option value="-1" id="selectOrgan">请选择下达部门</option>                         
                            </select> -->
                            <input type="hidden" name="subOrganId" value="${organ.id}">
                            <input type="text" name="organName" value="${organ.organName }" readonly="readonly"></td>
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
                    <td class="kv-content"><input type="text" name="executeTime" required="true"></td>
                    <td class="kv-label">风险登记</td>
                    <td class="kv-content">
                        <select name="riskLevel">
                            <option>请选择</option>
                            <option value="2">高</option>
                            <option value="1">中</option>
                            <option value="0">低</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="kv-label">任务执行情况</td>
                    <td class="kv-content">
                        <textarea rows="3" style="width: 90%;" name="taskState"></textarea>
                    </td>
                    <td class="kv-label">调查结论和意见</td>
                    <td class="kv-content" colspan="3">
                        <textarea rows="3" style="width: 90%;" name="idea"></textarea>
                    </td>
                </tr>
                </tbody>
            </table>
<!--             <div class="column">
                <span class="current">图片信息</span>
            </div>
            <table class="kv-table">
                <tbody>
                <tr>
                    <td class="kv-label">图片信息</td>
                    <td class="kv-content">
                        <input type="file" name="images">
                    </td>
                    <td class="kv-label">图片说明</td>
                    <td class="kv-content" colspan="3">
                        <input type="text" name="imageNote" style="width:80%" placeholder="请输入图片描述信息">
                    </td>
                </tr>
                <tr>
                    <td class="kv-label">图片信息</td>
                    <td class="kv-content">
                        <input type="file" name="images">
                    </td>
                    <td class="kv-label">图片说明</td>
                    <td class="kv-content" colspan="3">
                        <input type="text" name="imageNote" style="width:80%" placeholder="请输入图片描述信息">
                    </td>
                </tr>
                <tr>
                    <td class="kv-label">图片信息</td>
                    <td class="kv-content">
                        <input type="file" name="images">
                    </td>
                    <td class="kv-label">图片说明</td>
                    <td class="kv-content" colspan="3">
                        <input type="text" name="imageNote" style="width:80%" placeholder="请输入图片描述信息">
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="column">
                <span class="current">视频信息</span>
            </div>
            <table class="kv-table">
                <tbody>
                <tr>
                    <td class="kv-label">视频信息</td>
                    <td class="kv-content">
                        <input type="file" name="vedio">
                    </td>
                    <td class="kv-label">视频说明</td>
                    <td class="kv-content" colspan="3">
                        <input type="text" name="imageNote" style="width:80%" placeholder="请输入视频描述信息">
                    </td>
                </tr>
                <tr>
                    <td class="kv-label">视频信息</td>
                    <td class="kv-content">
                        <input type="file" name="vedio">
                    </td>
                    <td class="kv-label">视频说明</td>
                    <td class="kv-content" colspan="3">
                        <input type="text" name="imageNote" style="width:80%" placeholder="请输入视频描述信息">
                    </td>
                </tr>
                <tr>
                    <td class="kv-label">视频信息</td>
                    <td class="kv-content">
                        <input type="file" name="vedio">
                    </td>
                    <td class="kv-label">视频说明</td>
                    <td class="kv-content" colspan="3">
                        <input type="text" name="imageNote" style="width:80%" placeholder="请输入视频描述信息">
                    </td>
                </tr>
                </tbody>
            </table> -->
        </div>
        <div class="btn-selection">
            <a href="javascript:void(0);" id="save" class="easyui-linkbutton save-btn" data-options="selected:true">保存</a>
            <a href="javascript:void(0);" class="easyui-linkbutton reset-btn" data-options="selected:true">重置</a>
        </div>
    </div>
</div>
</form>
</body>
</html>
<script type="text/javascript" src="static/jquery/jquery.min.js"></script>
<script type="text/javascript" src="static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="static/js/calendar.js"></script>

<script type="text/javascript" src="static/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
$.extend($.fn.validatebox.defaults.rules, {
    choose: {
		validator: function(value,param){
			return value != -1;
		},
		message: '请选择'
    }
});
    $("input[name=executeTime]").datebox({
        formatter: easyUIFormater,
        parser: easyUIparser
    });
    $("input[name='payerCode']").bind("blur",function(){
    	var payerCode = $("input[name='payerCode']").val();
    	if(payerCode){
    	location.href="getTaxPayerInTask.do?payerCode="+payerCode
    	}
    })
    $.post("getOrganServlet.do",{},function(data){
			var organ = $("select[name='subOrganId']")
			$.each(data,function(index, val){
				organ.append("<option value='"+val.id+"'>"+val.organName+"</option>")
			})
		},"json");
	$.post("getTaxer.do",{},function(data){
			var industry = $("select[name='approverId']")
			$.each(data,function(index, val){
				industry.append("<option value='"+val.id+"'>"+val.taxerName+"</option>")
			})		
		},"json");
	$.post("getTaxer.do",{},function(data){
		var industry = $("select[name='executeId']")
		$.each(data,function(index, val){
			industry.append("<option value='"+val.id+"'>"+val.taxerName+"</option>")
		})
		
	},"json");
	$("#save").bind("click",function(){
		var state = $("#addForm").form('validate');
		if(state){
		$.post("addTask.do",$("#addForm").serialize(),function(result){
			if (result.success) {
				$.messager.alert("操作提示", "添加成功", "info");
			} else {
				$.messager.alert("操作提示", "添加失败", "error");
			}
		},"json")
		}
	})
</script>
