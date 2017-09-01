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
	<title>注册</title>
	<style type="text/css">
	*{font-size: 20px;}
	.content1{
		width: 500px;
		height:150px;
		margin: 30px auto 0;
	}
	.content2{
		text-align:center;
		width: 200px;
		height:40px;
		line-height: 40px;
		background: #BD3847;
		margin: 0 auto;
	}
	.content2 a{
		text-decoration:none;
		color:  #FFFFFF;
	}

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
    color:red;
    text-decoration: none;
}

.nav_center a:link,.nav_right a:visited{
    color: red;
    background-color:#3e3d43;
}

.nav_center a:hover,.nav_right a:active{
    color: #FFFFFF;
    background-color: #be3948;
}

.nav_right{
    float: left;
    width: 200px;
    height: 80px;
   line-height: 80px;
   text-align: center;
    font-size: 20px;
     display: block;
}
.nav_right a{
    font-size: 20px;
    text-decoration: none;
}

	</style>
	  <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
	function checkForm(){
		// 校验用户名:
		// 获得用户名文本框的值:
		var username = document.getElementById("username").value;
		if(username == null || username.length < 6){
			alert("用户名不能为空且长度大于等于6!");
			return false;
		}
		// 校验密码:
		// 获得密码框的值:
		var password = document.getElementById("password").value;
		if(password == null || password.length < 6){
			alert("密码不能为空且长度大于等于6!");
			return false;
		}
		// 校验确认密码:
		var repassword = document.getElementById("repassword").value;
		if(repassword != password){
			alert("两次密码输入不一致!");
			return false;
		}
	}
	
		function checkUsername() {
            // 获得文件框值:
            var username = $("#username").val();
            $.ajax({
                type: 'post',
                url: '<%=basePath%>valiUsername.action',
                data: 'userName=' + username,
                success: function (data) {
                    $("#span1").empty();
                    $("#span1").append(data);
                }
            });
        }
		function change() {
			var img1 = document.getElementById("checkImg");
			img1.src="<%=basePath%>checkImg.action?"+new Date().getTime();
		}
		
	</script>
  </head>
  
  <body>
  	<div class="top"></div><!--top结束-->
<div class="wrap">
    <jsp:include page="menu.jsp" />
	<form action="userRegist" method="post" onsubmit="return checkForm();" >
		<div class="content1">
			<table width="100%" border="0" >
			  <tr>
			    <td class="td1">*用户名</td>
			    <td>
			    	<input type="text" id="username" name="userName" placeholder="输入用户名 " onblur="checkUsername()" >
			    	<span id="span1"></span>
			    </td>
			  </tr>
			  <tr>
			    <td class="td2">*密码</td>
			    <td><input type="password" id="password" name="userPass"  placeholder="输入密码 " ></td>
			  </tr>
			  <tr>
			    <td class="td2">*确认密码</td>
			    <td><input type="password" id="repassword" placeholder="确认密码 " ></td>
			  </tr>
			   <tr>
			    <td class="td3">昵称</td>
			    <td><input type="text"  name="userPick"  ></td>
			  </tr>
			  <tr>
			    <td class="td4">邮箱</td><td><input type="email"  name="userEmail" placeholder="输入邮箱" ></td>
			  </tr>
			  <tr>
			    <td class="td5">手机号</td><td><input type="text"  name="userTel" placeholder="输入手机号(可选)" ></td>
			  </tr>
			  <tr>
			    <td class="td6">验证码</td><td><input type="text"  name="checkCode" maxlength="4" placeholder="请输入验证码"></td>
			    <td> <img id="checkImg" class="captchaImage" src="<%=basePath%>checkImg.action" onclick="change()" title="点击更换验证码"> </td>
			  </tr>
			  <tr>
			  
			  	<td colspan="2"><input class="content2" type="submit" value="注册"></td>
			  </tr>
			  
			</table>
		</div>
	</form>
		${msg}
</div>
  
  </body>
</html>
