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
        <a href="javascript:void(0);" id="addBtn" class="easyui-linkbutton" iconCls="icon-add">添加纳税人</a>
      </div>
    </div>
    <script type="text/javascript" src="static/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="static/easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
    $('#dg').datagrid({
        url:'TaxPayerServlet.action',
        rownumbers:true,
        pagination:true,
        method:'get',
        fitColumns:true,
        striped:true,
        columns:[[
        	//{field:'id',checkbox:'true'},
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
    		{field : "operation",
    			 title : "操作",
    			 formatter : function(value, row, index) {
    							return "<a href=\"javascript:void(0)\" onclick='del("+row.id+")'>删除</a>&nbsp;"
    							+
    							"<a href=\"javascript:void(0)\" onclick='upd("+row.id+")'>修改</a>&nbsp;"
    							+ "<a href='getTaxPayerInTask.do?payerCode="+row.payerCode+"'>新建任务</a>	";
    				}}

        ]]
    });

    
    var search = function(){
    	$('#dg').datagrid('load', {
    	 	payerCode:$("#tb input[name='payerCode']").val(),
    	    payerName:$("#tb input[name='payerName']").val() 
    	});
    } 
     $('#dg').datagrid({
    	toolbar: '#tb'
    }); 
    $("#searchBtn").bind("click",function(){
    	search();
    }) 
    $("#setBtn").bind("click",function(){
    	$("#payerCode").textbox("setValue","");
    	$("#payerName").textbox("setValue","");
    	search();
    }) 
   
    	//新增
           $("#addBtn").on("click",function(e){
              openTopWindow({
                  width : 1000,
                  height : 600,
                  title : "修改纳税人",
                  url : "manage/addTaxpayer.jsp"
              });
           });
       //修改
           var upd = function(id){
            	 openTopWindow({
                     width : 750,
                     height : 600,
                     title : "纳税人信息更新",
                     url : "getTaxPayerById.do?id="+id
                 });
             }
           function addTab(title, url){
               if ($('.easyui-tabs1').tabs('exists', title)){
                   $('.easyui-tabs1').tabs('select', title);
               } else {
                   var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
                   $('.easyui-tabs1').tabs('add',{
                       title:title,
                       content:content,
                       closable:true
                   });
               }
           }
       //新建任务
           /**
            *打开在父窗口中打开window
            */
           function openTopWindow(options){
               options = !options ? {} :options;
               options.width = !options.width ? 500 : options.width;
               options.height = !options.height ? 400 : options.height;
               options.url = !options.url ? "404.html" : options.url;
               options.title = !options.title ? "" : options.title;

               parent.$("#topWindow").window({
                   title : options.title,
                   width: options.width,
                   height: options.height,
                   closed:false,
                   content : "<iframe scrolling='no' frameborder='0' border='0' height='100%' width='100%' src='"+options.url+"'></iframe>",
                   modal:true,
                   resizable:false,
                   collapsible:false
               });
           }

 
    var del = function(id) {
   	 $.messager.confirm("警告","确定删除？",function(data){
            if(data){
            	 $.post("deleteTaxPayer",{"id":id},function(result){
           		 if(result.success){
           			 $.messager.alert('My Title','删除成功','info',function(){
							 window.location.href="manage/listTaxPayer.jsp";
           		       })
           		 }
           		 else{
           			 $.messager.alert('My Title','删除失败','info');
           		 }
           	 },"json");
            }
        });
   }
    </script>
</body> 
</html>
