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
    <title>办税专员管理</title>

    <link href="static/css/base.css" rel="stylesheet">
    <link rel="stylesheet" href="static/easyui/uimaker/easyui.css">
    <link rel="stylesheet" type="text/css" href="static/easyui/uimaker/icon.css">
    <link rel="stylesheet" href="static/css/taxpayer.css">
</head> 
<body>
    <div class="container">
       <table id="dg">
        </table>
        <form>
      <div id="tb" style="padding:0 30px;">
        办税专员名称: <input id="taxer" class="easyui-textbox" type="text" name="taxerName" style="width:166px;height:35px;line-height:35px;"/>
        <a href="javascript:void(0);" id="searchBtn" class="easyui-linkbutton" iconCls="icon-search">查询</a>
        <a href="javascript:void(0);" id="setBtn" class="easyui-linkbutton" iconCls="icon-reload">重置</a>
       <!--  <a href="javascript:void(0);" id="delBtn" class="easyui-linkbutton" iconCls="icon-cut">删除</a> -->
        <a href="javascript:void(0);" id="addBtn" class="easyui-linkbutton" iconCls="icon-add">添加办税人员</a>
      </div></form>
      
    </div>
    <script type="text/javascript" src="static/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="static/easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
    $('#dg').datagrid({
        url:'TaxerServlet.action',
        rownumbers:true,
        pagination:true,
        method:'get',
        fitColumns:true,
        striped:true,
        columns:[[
        	//{field:'id',checkbox:'true'},
    		{field:'taxerCode',title:'办税专员编号'},
    		{field:'taxerName',title:'办税专员名称'},
    		{field:'mobile',title:'手机号'},
    		{field:'address',title:'地址'},
    		{field:'email',title:'邮箱'},
    		{field:'sex',title:'性别'},
    		{field:'birthday',title:'生日'},
    		{field:'organName',title:'所属税务机关'},
    		{field : "operation",
    			 title : "操作",
    			 formatter : function(value, row, index) {
    							var src = "<a href='javascript:void(0)' onclick='del("+row.id+")'>删除</a>&nbsp;"
    							+ "<a href=\"javascript:void(0)\" onclick='upd("+row.id+")'>修改</a>	";
    							
    							return src;    							
    				}}
        ]]
    });

    var search = function(){
    	$('#dg').datagrid('load', {
    		taxerName:$("#tb input[name='taxerName']").val(),
    	});
    } 
     $('#dg').datagrid({
    	toolbar: '#tb'
    }); 
     $("#searchBtn").bind("click",function(){
     	search();
     });
     $("#setBtn").on("click",function(){
 		$("#taxer").textbox("setValue","")
 		search();
     }) 
      
           $("#addBtn").on("click",function(e){
              openTopWindow({
                  width : 750,
                  height : 600,
                  title : "新增办税专员",
                  url : "manage/addTaxer.jsp"
              });
           });

           //修改信息
           var upd = function(id){
          	 openTopWindow({
                   width : 750,
                   height : 600,
                   title : "办税专员信息更新",
                   url : "getTaxerById?id="+id
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
     var del = function(id) {
    	 $.messager.confirm("警告","确定删除？",function(data){
             if(data){
             	 $.post("deleteTaxer",{"id":id},function(result){
            		 if(result.success){
            			 $.messager.alert('My Title','删除成功','info',function(){
							 window.location.href="manage/listTaxer.jsp";
            		       })
            		 }
            		 else{
            			 $.messager.alert('My Title','删除失败,存在对应的任务','error');
            		 }
            	 },"json");
             }
         });
    }

    </script>
</body> 
</html>
