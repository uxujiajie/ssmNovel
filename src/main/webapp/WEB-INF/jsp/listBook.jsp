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
    
    <title>所有小说</title>
 	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css">
  </head>
  
  <body>
   <div class="wrap">
  <jsp:include page="menu.jsp"></jsp:include>
	  <table>
	  
	    <tr>
			<c:forEach items="${pageBean.beanList}" var="book" varStatus="mar">
				<td>
					<img src='<%=picPath%>${book.bookimage}' alt='${book.bookname}' width="330px" height="280px">
					<br/>
					<a href='<%=basePath%>findTheBook/${book.id}'>${book.bookname} </a>
					&nbsp;&nbsp;&nbsp;著:${book.author}
				</td>
				<td>
					<textarea cols="16" rows="15" readonly="readonly">${book.intro}</textarea>
				</td>
				<c:choose>
					<c:when test="${mar.count % 2 == 0}">
		</tr><tr>
					</c:when>
				</c:choose>
			</c:forEach>
	    </tr>
	   </table>
	   
	   <a href='<%=basePath%>${pageBean.url}.action?pc=1' >首页</a>

	   <c:choose>
		   <c:when test="${pageBean.tp < 10}">
			   <c:set var="begin" value="1" />
			   <c:set var="end" value="${pageBean.tp}" />
		   </c:when>
		   <c:otherwise>
			   <c:set var="begin" value='${pageBean.pc - 5}' />
			   <c:set var="end" value='${pageBean.pc + 4} '/>
			   <c:when test="${begin < 1}">
				   <c:set var="begin" value="1" />
				   <c:set var="end" value="10" />
			   </c:when>
			   <c:when test="${pageBean.pc < end}">
				   <c:set var="begin" value="${pageBean.tp - 9}" />
				   <c:set var="end" value="${pageBean.tp}" />
			   </c:when>
		   </c:otherwise>
	   </c:choose>
	   <c:forEach var="i" begin="${begin}" end="${end}">
		   <c:choose>
			   <c:when test="${i == pageBean.pc}">
				   [${i} ]
			   </c:when>
			   <c:otherwise>
				   <a href="<%=basePath%>${pageBean.url}.action?pc=${i }" >${i }</a>
			   </c:otherwise>
		   </c:choose>
	   </c:forEach>
   	<a href='<%=basePath%>${pageBean.url}.action?pc=${pageBean.tp}' >尾页</a>
  </div>
  </body>
</html>
