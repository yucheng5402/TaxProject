<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"> 
<head>
    <base href="<%=basePath %>">
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <title>纳税人管理</title>

    <link href="static/css/base.css" rel="stylesheet">
    <link rel="stylesheet" href="static/easyui/uimaker/easyui.css">
    <link rel="stylesheet" type="text/css" href="static/easyui/uimaker/icon.css">
    <link rel="stylesheet" href="static/css/taxpayer.css">
</head> 
<body>
    <div class="container">
       <table id="dg">
        </table>
      <div id="tb" style="padding:0 30px;">
        纳税人识别号: <input  id="payerCode" class="easyui-textbox" type="text" name="payerCode" style="width:166px;height:35px;line-height:35px;"/>
        纳税人名称:  <input  id="payerName" class="easyui-textbox" type="text" name="payerName" style="width:166px;height:35px;line-height:35px;"/>
        <a href="javascript:void(0);" id="searchBtn" class="easyui-linkbutton" iconCls="icon-search" data-options="selected:true">查询</a>
        <a href="javascript:void(0);" id="setBtn" class="easyui-linkbutton" iconCls="icon-reload">重置</a>
      
      </div>
    </div>
    <script type="text/javascript" src="static/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="static/easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
    $('#dg').datagrid({
        url:'getTaxPayerWithoutTask.do',
        rownumbers:true,
        pagination:true,
        method:'get',
        fitColumns:true,
        striped:true,
        columns:[[
    		{field:'payerCode',title:'纳税人识别号'},
    		{field:'payerName',title:'纳税人名称'},
    		{field:'organName',title:'所属税务机关'},
    		{field:'industryName',title:'所属行业'},
    		{field:'legalPerson',title:'法人代表'},
    		{field:'legalIdCard',title:'法人身份证号码'},
    		{field:'finaceName',title:'主管财务'},
    		{field:'finaceIdCard',title:'财务身份证号码'},
    		{field:'taxerName',title:'办税人员'},
    		{field:'recordDate',title:'录入日期'},

        ]]
    });
     $('#dg').datagrid({
    	toolbar: '#tb'
    }); 
     
     var search = function(){
     	$('#dg').datagrid('load', {
     		payerCode:$("#tb input[name='payerCode']").val(),
     	    payerName:$("#tb input[name='payerName']").val()
     	});
     } 
     $("#searchBtn").bind("click",function(){
     	search();
     }) 
     $("#setBtn").bind("click",function(){
     	$("#payerCode").textbox("setValue","");
     	$("#payerName").textbox("setValue","");
     	search();
     }) 

    </script>
</body> 
</html>
