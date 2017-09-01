<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>错误页面</title>
<link href="<%=basePath%>css/storyall.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="divcontent">
<table width="850px" border="0" cellspacing="0">
  <tr>
    <td style="padding:30px; text-align:center"><table width="60%" border="0" cellspacing="0" style="margin-top:70px">
      <tr>
        <td ><img src="<%=basePath%>images/msg.jpg" width="350" height="300" /></td>
        <td style="padding-top:30px"><font style="font-weight:bold; color:#FF0000">
	       ${msg}
        </font>
        <br />
            <br />
          <a href="<%=basePath%>turnIndex.action">首页</a>
          <a href="<%=basePath%>userRegistPage.action">注册</a>
          <a href="<%=basePath%>loginUser.action">登录</a>
         </td>
      </tr>
    </table>
    <h1>&nbsp;</h1></td>
    </tr>
</table>
</div>
</body>
</html>