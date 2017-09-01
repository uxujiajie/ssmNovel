<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>添加书籍</title>
  </head>
  
  <body>
    	<form action="<%=basePath%>addBook_haveUser" method="post" enctype="multipart/form-data" >
    		书名: <input type="text" name="bookname" >		<br/>
    		封面: <input type="file" name="upload" >		<br/>
    		简介: <input type="text" name="intro" width="150" height="150">	<br/>
    		作者: <input type="text" readonly="true" name="author" value="${sessionScope.user.userName }">
			<input type="hidden" name="userId" value="${sessionScope.user.id}">
    		<br/>
    		所属分类:<select name="categoryid">
    			<c:forEach items="${requestScope.categoryList}" var="cate">
					<option value='<c:out value="${cate.id}"/>'><c:out value="${cate.catename}"></c:out></option>
				</c:forEach>
    		</select>
    		<input type="submit" value="发布小说">
    	</form>
  		${msg}
  </body>
</html>
