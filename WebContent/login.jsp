<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>河南省税务管理系统</title>
    <link href="static/css/base.css" rel="stylesheet">
    <link href="static/css/login/login.css" rel="stylesheet">
    <link href="static/easyui/uimaker/easyui.css" rel="stylesheet">
    	
    <script type="text/javascript" src="static/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="static/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="static/easyui/easyui-lang-zh_CN.js"></script>
  </head>
  
  <body onLoad="checkCookie()">
  <div class="login-hd">
		<div class="left-bg"></div>
		<div class="right-bg"></div>
		<div class="hd-inner">
			<span class="sys-name">xx省国税税源信息管理系统</span>
		</div>
	</div>
	<div class="login-bd">
		<div class="bd-inner">
			<div class="inner-wrap">
				<div class="lg-zone">
					<div class="lg-box">
						<div class="lg-label"><h4>用户登录</h4></div>
						<div id="error" class="alert alert-error">
			              <i class="iconfont">&#xe62e;</i>
			              <span id="info">请输入用户名</span>
			            </div>
						<form method="post" id="loginForm" action="UserManageServlet">
							<div class="lg-username input-item clearfix">
								<i class="iconfont">&#xe60d;</i>
								<input type="text" name="username" id="username" placeholder="系统账号">
							</div>
							<div class="lg-password input-item clearfix">
								<i class="iconfont">&#xe634;</i>
								<input type="password" name="password" id="password" placeholder="系统密码">
							</div>
							<div class="lg-check clearfix">
								<div class="input-item">
									<i class="iconfont">&#xe633;</i>
									<input type="text" name="captcha" id="captcha" placeholder="验证码">
								</div>
								<span class="check-code"><img id="captchaimg" src="CaptchaServlet"></span>
							</div>
							<div class="tips clearfix">
								<label><input type="checkbox" id="rem" name="remUser" checked="checked">记住用户名</label>
								<a href="javascript:;" class="forget-pwd">忘记密码？</a>
							</div>
							<div class="enter">
								<a href="javascript:void(0);" class="supplier">登录</a>
								<a href="javascript:void(0);" class="purchaser">重置</a>
							</div>
						</form>
					</div>
				</div>
				<div class="lg-poster"></div>
			</div>
		</div>
	</div>
	<div class="login-ft">
		<div class="ft-inner">
			<div class="about-us">
				<a href="javascript:;">关于我们</a>
				<a href="javascript:;">法律声明</a>
				<a href="javascript:;">服务条款</a>
				<a href="javascript:;">联系方式</a>
			</div>
			<div class="address">地址：湖北省洪山区光谷国际广场B座24楼&nbsp;邮编：430070&nbsp;&nbsp;Copyright&nbsp;©&nbsp;2015&nbsp;-&nbsp;2017&nbsp;专注系统集成&nbsp;版权所有</div>
			<div class="other-info">建议使用IE8及以上版本浏览器&nbsp;京ICP备&nbsp;17003078号&nbsp;E-mail：service@zhidisoft.com</div>
		</div>
	</div>
	<div  id="dialog" style="padding:20px;line-height: 1.5em;"></div>
    	
  </body>
  <script type="text/javascript">
  	function login(){
 		var username=$("#username").val();
		var password=$("#password").val();
		var captcha=$("#captcha").val();
		var remUser=$("#rem").val();
		if(!username||username.length<5){
			$("#error").show()
			$("#info").text("用户名输入错误").css("color","red");
			return;
		}else{
			$("#info").text("")
		}
        if(!password){
        	$("#error").show()
			$("#info").text("请输入密码").css("color","red");
			return;
		}else{
			$("#info").text("")
        }
		if(!captcha||captcha.length!=4){
			$("#error").show()
			$("#info").text("验证码为4位").css("color","red");
			return;
		}else{
			$("#info").text("")
		}
		//验证码验证
		$.get("LoginServlet",{"captcha":captcha},function(result){
			if(result == "false"){
				$("#error").show()
				$("#info").text("验证码错误").css("color","red");
				$("#captchaimg").attr("src","CaptchaServlet?num=" + Math.random())
				return;
			}else{
				$("#info").text("");
				$.post("LoginServlet",{"username":username,"password":password},function(result){
					if(result == "false"){
						$("#error").show()
						$("#info").text("用户名或密码错误").css("color","red");
						return;
					}else{
						if($("#rem").is(':checked')){
							checkCookie1();
						}
						else{
							checkCookie2();
						}
						$("#loginForm").submit();
					}
				},"html")
				
			}
		},"html")
		//验证码通过之后进行登录
  	}
  	//设置cookie
  	function setCookie(c_name,value,expiredays)
       {
          var exdate=new Date()
          exdate.setDate(exdate.getDate()+expiredays)
          document.cookie=c_name+ "=" +escape(value)+
           ((expiredays==null) ? "" : ";expires="+exdate.toGMTString())
       }
  	//获取cookie 判断是否存在cookie
  	
			function getCookie(c_name) {
				if (document.cookie.length > 0) {
					c_start = document.cookie.indexOf(c_name + "=")
					if (c_start != -1) {
						c_start = c_start + c_name.length + 1
						c_end = document.cookie.indexOf(";", c_start)
						if (c_end == -1)
							c_end = document.cookie.length
						return unescape(document.cookie.substring(c_start,
								c_end))
					}
				}
				return ""
			}
  	//如果 cookie 已设置，则显示用户名，否则不显示
  	      function checkCookie() {
				username = getCookie('username')
				if (username != null && username != "") {
					$("#username").val(username)
				} else {
					return
				} 
			}
  	//选中checkbox 设置cookie
  	    function checkCookie1() {
			username = $("#username").val()
				setCookie('username', username, 365)
	          }
  	//不选checkbox
  	function checkCookie2() {
		     username = getCookie('username');
		     setCookie('username', "", 365)
		
	}
			$(function() {
				var username = document.cookie.split("=")[1]

				//放入cookie值
				$("#username").val(username)
				$("#error").hide()
				$("#captchaimg").on("click", function() {
					var num = Math.random()
					this.src = "CaptchaServlet?num=" + Math.random()
				})
				$(".forget-pwd")
						.on(
								"click",
								function() {
									$.messager
											.alert("提醒",
													"本项目为管理系统不提供用户自行找回密码功能，密码忘记只能通过系统管理员对密码进行初始化")
								})
				$(".supplier").on("click", function() {
					login();
				})
                $(".purchaser").on("click",function(){
                	location.href="login.jsp"
                })
				
				$("form").keydown(function() {
					if (event.keyCode == "13") {//keyCode=13是回车键
						login();
					}
				});
			})
		</script>
</html>
