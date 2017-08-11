<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <base href="/TaxSource/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>添加纳税人</title>
    <link rel="stylesheet" type="text/css" href="static/css/base.css" >
    <link rel="stylesheet" type="text/css" href="static/easyui/uimaker/easyui.css">
    <link rel="stylesheet" type="text/css" href="static/easyui/uimaker/icon.css">
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
                <div class="column"><span class="current">添加纳税人信息</span></div>
                <table class="kv-table">
                    <tbody>
                    <tr>
                        <td class="kv-label">纳税人识别号</td>
                        <td class="kv-content">
                        <input type="text" name="payerCode" value="${payer.payerCode }" 
                        placeholder="纳税人识别号" readonly="readonly" class="easyui-validatebox" data-options="required:true"></td>
                        <td class="kv-label">纳税人名称</td>
                        <td class="kv-content">
                        <input type="text" name="payerName" value="${payer.payerName }" 
                        placeholder="纳税人名称" readonly="readonly" class="easyui-validatebox" data-options="required:true"></td>
                    </tr>
                    <tr>
                        <td class="kv-label">生产经营地址</td>
                        <td class="kv-content"><input type="text" name="bizAddress" value="${payer.bizAddress }" placeholder="生产经营地址" class="easyui-validatebox" data-options="required:true"></td>
                        <td class="kv-label">经营地电话</td>
                        <td class="kv-content"><input type="text" name="bizAddressPhone" value="${payer.bizAddressPhone }" placeholder="生产经营地电话" class="easyui-validatebox" data-options="required:true"></td>
                    </tr>
                    <tr>
                        <td class="kv-label">所属税务机关</td>
                        <td class="kv-content">
                            <select name="taxOrganId" class="easyui-validatebox" validType="choose">
                                <option value="-1" id="selectOrgan">请选择所属税务机关</option>                         
                            </select>
                        </td>
                        <td class="kv-label">行业</td>
                        <td class="kv-content">
                            <select name="industryId" class="easyui-validatebox" validType="choose">
                                <option value="-1" id="selectIndustry">请选择纳税人行业</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">生产经营范围</td>
                        <td class="kv-content">
                            <input type="text" name="bizScope" value="${payer.bizScope }" 
                            placeholder="生产经营范围" class="easyui-validatebox" data-options="required:true">
                        </td>
                        <td class="kv-label">票种核定</td>
                        <td class="kv-content">
                            <select name="invoiceType" class="easyui-validatebox" validType="choose">
                                <option value="-1">请选择发票种类</option>
                                <option value="增值税普通发票">增值税普通发票</option>
                                <option value="增值税专用发票">增值税专用发票</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">法人代表人</td>
                        <td class="kv-content">
                            <input type="text" name="legalPerson" value="${payer.legalPerson }" 
                            placeholder="法人姓名" class="easyui-validatebox" data-options="required:true">
                        </td>
                        <td class="kv-label">法人身份证号</td>
                        <td class="kv-content">
                            <input type="text" name="legalIdCard" value="${payer.legalIdCard }" 
                            placeholder="法人代表身份证号码" class="easyui-validatebox" data-options="required:true">
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">主管财务</td>
                        <td class="kv-content">
                            <input type="text" name="finaceName" value="${payer.finaceName }" 
                            placeholder="主管财务" class="easyui-validatebox" data-options="required:true">
                        </td>
                        <td class="kv-label">财务身份证号</td>
                        <td class="kv-content">
                            <input type="text" name="finaceIdCard" value="${payer.finaceIdCard }" 
                            placeholder="财务身份证号" class="easyui-validatebox" data-options="required:true">
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">办税专员</td>
                        <td class="kv-content">
                            <select name="taxerName" class="easyui-validatebox" validType="choose">
                                <option value="-1">请选择办税专员</option>
                            </select>
                        </td>
                        <td class="kv-label">录入日期</td>
                        <td class="kv-content"><input type="text" name="recordDate" value='<fmt:formatDate  value="<%=new Date() %>"/>' readonly="readonly" ></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="btn-selection">
                <a href="javascript:void(0);" iconcls="icon-ok" class="easyui-linkbutton save-btn" data-options="selected:true">保存</a>
                <a href="javascript:void(0);" iconcls="icon-reload" class="easyui-linkbutton reset-btn" data-options="selected:true">重置</a>
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
	$(function(){
	
		$.post("getOrganServlet.do",{},function(data){
			var organ = $("select[name='taxOrganId']")
			$.each(data,function(index, val){
				organ.append("<option value='"+val.id+"'>"+val.organName+"</option>")
			})
			$("select:eq(0)").val('${payer.taxOrganId}')
		},"json")

		// ajax请求获取外键值
		$.post("getIndustry.do",{},function(data){
			var industry = $("select[name='industryId']")
			$.each(data,function(index, val){
				industry.append("<option value='"+val.id+"'>"+val.industryName+"</option>")
			})
			$("select:eq(1)").val('${payer.industryId}')
		},"json");
		$.post("getTaxer.do",{},function(data){
			var industry = $("select[name='taxerName']")
			$.each(data,function(index, val){
				industry.append("<option value='"+val.taxerName+"'>"+val.taxerName+"</option>")
			})
			$("select:eq(3)").val('${payer.taxerName}')
		},"json");
		$("select:eq(2)").val('${payer.invoiceType}')
	})
	
	//
	$("a:eq(1)").bind("click",function(){
		$("#addForm").form('reset')
	})
	$("a:eq(0)").bind("click",function(){
		  var state = $("#addForm").form('validate');
		  if(state){
			  $.post("updateTaxPayer.do",$("form").serialize(), function(result) {
					
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


