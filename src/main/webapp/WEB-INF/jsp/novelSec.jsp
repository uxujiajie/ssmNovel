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
    
    <title>小说章节</title>
    <link href="<%=basePath%>css/storyall.css" rel="stylesheet" />
    <style type="text/css">
	body{
        background-color: #98FB98;
        background-size:cover;
	}
    #content2{
        font-family:Arial,Verdana,Sans-serif;
        background-size:500%;
        text-align:left;
    }
</style>
  </head>
  
  <body>
  <div id="container">
 	<a name="huidaodingbu"></a>
	<p class="haha">>>>当前位置 <a href="<%=basePath%>turnIndex.action">首页</a>
	<a href='<%=basePath%>findTheBook/${secExam.bookid }'>${secExam.bookName}</a></p>
	<h2>${secExam.sectiontitle }</h2>
        <div id="content2">
         <font size="4"> ${secExam.content}  </font>
        </div>
      <br/>
      <c:choose>
          <c:when test="${secExam.sectionnum > 1}">
              <a href="<%=basePath%>lookSecContent?secNumId=${secExam.sectionnum-1}&bookId=${secExam.bookid}">上一章</a>
          </c:when>
      </c:choose>
      <c:choose>
          <c:when test="${secExam.sectionnum < secExam.bookNum}">
              <a href="<%=basePath%>lookSecContent?secNumId=${secExam.sectionnum+1}&bookId=${secExam.bookid}">下一章</a>
          </c:when>
      </c:choose>
  	</div>
  </body>
</html>
