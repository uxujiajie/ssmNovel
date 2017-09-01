<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
<meta charset="UTF-8">
	<title>登录</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/main.css">
	<style type="text/css">
	*{font-size: 20px;}
	.aa{
		
		width: 250px;
		height: 500px;
		margin: 20px auto;
	}
	.bb{
		text-align: center;
	}
	.cc{
		text-align: center;
	}
	.dd{
	width: 250px;
			}
			.ee{width: 120px;
	float: left;
			}
			.ff{width: 120px;
				text-align: right;
	float: right;
			}
			
			.gg{
				width:200px;
				height: 30px;
				line-height: 30px;
				margin: 10px 23px ;
	display:inline-block;
	text-align: center;
	background: #BD3847;
}
	.gg a{
		text-decoration:none;
		color:  #FFFFFF; }



.wrap{
    width: 1000px;
    margin: 0 auto;
}

.nav{
    height: 60px;
    background: #FFFFFF;
}

.nav_left{
    width: 200px;
    float: left;
}

.nav_center li{
    list-style-type: none;
    float: left;
    line-height: 60px;
    width: 133px;
    text-align: center;
}

.nav_center li a{
    display: block;
    font-size: 16px;
    font-family: "微软雅黑";
    color: red;
    text-decoration: none;
}

.nav_center a:link,.nav_right a:visited{
    color: #EF8808;
    background-color:#3e3d43;
}

.nav_center a:hover,.nav_right a:active{
    color: #FFFFFF;
    background-color: #be3948;
}


	</style>
	
	
  </head>
  
  <body>
    <div class="top"></div><!--top结束-->
<div class="wrap">
    <jsp:include page="menu.jsp" />
	<div class="aa">
		<form action="<%=basePath%>loginUser" method="post">
		<div class="bb"><input type="text"  name="userName" placeholder="用户名 "></div>
		<br/>
		<div class="cc"><input type="password"  name="userPass" placeholder="请输入密码"/></div>
		
		<div class="dd">
		<div class="ee"><input name="autoLogin" type="checkbox"/>自动登录 	
		</div>
		<div class="ff"><a href="#" >忘记密码?</a></div>
			<font color="#dc143c">${msg}</font>
		</div>
		<div class="gg"><span><input type="submit" value="登录" ></span></div>
		</form>
	</div>
</div>
  </body>
</html>
