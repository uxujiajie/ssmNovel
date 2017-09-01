<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

  
  <div class="login">
    <div class="login1">
        <c:choose>
            <c:when test="${empty sessionScope.user}">
                <a href="<%=basePath%>userLoginPage.action">登录</a>|<a href="<%=basePath%>userRegistPage.action">注册</a>
            </c:when>
            <c:otherwise>
                用户名:<a href="<%=basePath%>userLookComment.action"><c:out value="${sessionScope.user.userPick}"></c:out></a>
                <a href="<%=basePath%>logoutUser.action">注销</a>
            </c:otherwise>
        </c:choose>
    </div>
  </div>

<div class="wrap">
    <div class="nav">
        <div class="nav_left">
            <img src="<%=basePath%>images/LOGO1.jpg" alt="说天下网Logo" width="200px" height="60px">
        </div><!--nav_left结束-->
        
        <div class="nav_center">
            <ul>
                <li><a href="<%=basePath%>turnIndex.action">首页</a></li>
                <li><a href="<%=basePath%>findAllByPage.action">全部作品</a></li>
                <li><a href="<%=basePath%>findAllByPageHits.action">排行</a></li>
                <li><a href="<%=basePath%>findAllByPageUpdate.action">更新</a></li>
                <li><a href="<%=basePath%>findAllByPageCreate.action">最新</a></li>
            	<li><a href='<%=basePath%>turnWriterPage_haveUser.action'>作家专区</a></li>
            </ul>
        </div><!--nav_right结束-->
        
    </div><!--nav结束-->
    
 </div>

