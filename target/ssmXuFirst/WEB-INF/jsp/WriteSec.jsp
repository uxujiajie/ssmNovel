<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String picPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"//pic";
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>写书</title>
      <script src="<%=basePath%>js/jquery-1.8.3.js"></script>
      <script>
         function doIt() {
             $("#form1").attr({action:"<%=basePath%>writeSec"});
           $("#form1").submit();
         }

      </script>
  </head>
  
  <body>
    <form id="form1" action="<%=basePath%>writeSec_haveUser" method="post" >
    	<input type="hidden" name="bookid" value='${requestScope.bookId}'>
        章节标题:<input type="text" name="sectiontitle">		<br/>
    	章节内容:<textarea cols="5" style="width:900px;height:600px;" name="bookContent"></textarea>	<br/>
    	<input type="submit" value="提交">
    </form>
  </body>
</html>
