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
    <title>任务查询</title>

<link href="static/css/base.css" rel="stylesheet">
<link rel="stylesheet" href="static/easyui/uimaker/easyui.css">
<link rel="stylesheet" type="text/css" href="static/easyui/uimaker/icon.css">
</head> 
<body>
<form id="seForm">
    <div class="container">
       <table id="dg">
           
        </table>
      <div id="tb" style="padding:0 30px;">
        <div class="conditions">
            <span class="con-span">纳税人识别号: </span><input class="easyui-textbox" type="text" name="payerCode" style="width:166px;height:35px;line-height:35px;">
            <span class="con-span">纳税人名称: </span><input class="easyui-textbox" type="text" name="payerName" style="width:166px;height:35px;line-height:35px;">
            <span class="con-span">税务机关: </span>
            <select name="subOrganId" class="easyui-validatebox" 
            style="width:166px;height: 35px">
                                <option value="-1" id="selectOrgan">请选择下达部门</option>                     
                            </select>
            <span class="con-span" >行业: </span>
            <select name="industryId" class="easyui-validatebox"
            style="width:166px;height: 35px">
            <option value="-1">请选择行业</option></select>
            
        </div>
        <div class="conditions hide">
            
            <span class="con-span">任务开始时间: </span>
            <input class="easyui-datebox" type="text" name="startTime" style="width:166px;height:35px;line-height:35px;">
            <span class="con-span">任务结束时间: </span>
            <input class="easyui-datebox" type="text" name="endTime" style="width:166px;height:35px;line-height:35px;">
            
            <a href="javascript:void(0);" id="search" class="easyui-linkbutton" iconCls="icon-search" data-options="selected:true">查询</a>
            <a href="javascript:void(0);" id="res" class="easyui-linkbutton" iconCls="icon-reload">重置</a>
            <a href="javascript:void(0);" class="easyui-linkbutton more" iconCls="icon-more">更多</a>
        </div>
      </div>
    </div>
    </form>
    <script type="text/javascript" src="static/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="static/easyui/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">

    
    $('#dg').datagrid({
        url:'TaxSourceServlet.action',
        rownumbers:true,
        pagination:true,
        method:'get',
        fitColumns:true,
        striped:true,
        columns:[[
        	
    		{field:'taskName',title:'任务名称'},
    		{field:'payerCode',title:'纳税人识别号'},
    		{field:'payerName',title:'纳税人名称'},
    		{field:'industryName',title:'行业'},
    		{field:'bizScope',title:'经营范围'},
    		{field:'executeTime',title:'执行时间'},
    		{field:'recordTaskDate',title:'录入时间'},
    		{field:'outTime',title:'录入超时(天)'},
    		{field : "operation",
    			 title : "操作",
    			 formatter : function(value, row, index) {
    				            var  ab = "www.baidu.com?id = " + value;
    							return "<a href= \"javascript:void(0)\" onclick='del("+row.id+")'>删除</a>&nbsp;"
    							+
    							"<a href=\"javascript:void(0)\" onclick='upd("+row.id+")'>修改</a>&nbsp;"
    							+ "<a href=\"javascript:void(0)\" onclick='show("+ row.id+")'>查看任务</a>	";
    							
    				}}

        ]]
    });

   
    $('#dg').datagrid({
    	toolbar: '#tb'
    });   
     
    var search = function(){
     	$('#dg').datagrid('reload', {
     		payerCode:$("input[name='payerCode']").val(),
     		payerName:$("input[name='payerName']").val(),
     		subOrganId:$("select[name='subOrganId']").val(),
     		startTime:$("input[name='startTime']").val(),
     		endTime:$("input[name='endTime']").val(),
     		industryId:$("select[name='industryId']").val()
     	});
     } 
     $("#search").bind("click",function(){
      	search();
      });
      $("#res").bind("click",function(){
    	$("#seForm").form('reset')
  		search();
      }) 
     
     
     $.post("getOrganServlet.do",{},function(data){
			var organ = $("select[name='subOrganId']")
			$.each(data,function(index, val){
				organ.append("<option value='"+val.id+"'>"+val.organName+"</option>")
			})
		},"json");
     $.post("getIndustry.do",{},function(data){
			var industry = $("select[name='industryId']")
			$.each(data,function(index, val){
				industry.append("<option value='"+val.id+"'>"+val.industryName+"</option>")
			})
		},"json");
     var del = function(id) {
       	 $.messager.confirm("警告","确定删除？",function(data){
                if(data){
                	 $.post("deleteTask.do",{"id":id},function(result){
               		 if(result.success){
               			 $.messager.alert('My Title','删除成功','info')
               			  $('#dg').datagrid('reload', {});
               		 }
               		 else{
               			 $.messager.alert('My Title','删除失败','info');
               		 }
               	 },"json");
                }
            });
       }
     var show = function(id){
      	 openTopWindow({
               width : 800,
               height : 600,
               title : "任务信息",
               url :  "getTaskInfo.do?id="+id
           });
       }
     var upd = function(id){
      	 openTopWindow({
               width : 1000,
               height : 700,
               title : "任务信息",
               url : "getTaskInfoToUpdate.do?id="+id
           });
       }
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
    </script>
</body> 
</html>
