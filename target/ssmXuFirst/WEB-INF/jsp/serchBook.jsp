<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>搜索图书</title>
    
	 <link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css">

  </head>
  
  <body>
  	<div class="wrap">
		<jsp:include page="menu.jsp" />
	    	
	    <table>
	  		<tr>
				<c:forEach items="${bookList}" var="book" varStatus="mar">
		    		<td>
		                <img src='<%=basePath%>${book.bookimage}' alt='${book.bookname}' width="330px" height="130px">
		                <br/>
		                <a href='<%=basePath%>findTheBook/${book.id}'>${book.bookname} </a>
		             </td>
		             <td>${book.author}</td>
		    		<td>
		             	<textarea cols="27" rows="9" readonly="readonly">${book.intro}</textarea>
		             </td>
					<c:choose>
						<c:when test="${mar.count % 2 == 0}">
							</tr><tr>
						</c:when>
					</c:choose>
				</c:forEach>
	   		</tr>
	   </table>
	    	
  	</div>
  </body>
</html>
