<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String picPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"//pic";
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
<html>
  <head>
    <title>我的书架</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css">
		
		<script type="text/javascript">
			function checkeAll() {
            	var rocks = document.getElementsByName("rocks");
            	for(var i = 0; i < rocks.length; i++)
            	{
            		var e = rocks[i];
            		e.checked = !e.checked; 
            	}
        	}
			function deleteChecked() {
				alert("进入删除方法");
            	var rocks = document.getElementsByName("rock");
            	var delete1 = document.getElementsByName("deleteR");
            	for(var i = 0; i < rocks.length; i++)
            	{
            		if(rocks[i].checked == true)
            		{
            			alert(rocks[i].id);
            			delete1.src="www.baidu.com";
            		}
            	}
        	}
		
		</script>
		
		<style type="text/css">
		*{font-size: 16px;}
			.shujia{
				width: 1000px;
				margin: 20px auto;
			}
			.shujia table{
				margin: 0 auto;
				text-align: center;
				border: 1px solid #D4AF5E;
			}
			.tuijs{
				width: 1000px;
				margin: 30px auto;
			}
			.tuijs h1{
				text-align: center;
				font-size: 20px;
			}
			.tuijs_img {
				margin: 10px 100px 0;
			}
			.tuijs_img img{
				margin: 10px 15px 0;
				display: inline-block;
			}
			.tuijs_a{
				width: 1000px;
				text-align: right;
			}
		</style>
  </head>
  
  <body>
    <div class="wrap">
    	<jsp:include page="menu.jsp"></jsp:include>
	</div>


	<div class="shujia">
	<form action="deleteRack" method="post">
	<table border="1" cellpadding="0">
	<tr>
		<td width="50"></td>
		<td width="150">书名</td>
		<td width="100">更新时间</td>
		<td width="50">作者</td>
	</tr>
	<c:forEach items="${user.bookList}" var="book" >
		<tr>
			<td><input type="checkbox" name="bookIds" value='${book.id}' /></td>
			<td><a href="<%=basePath%>findTheBook/${book.id}"> ${book.bookname}</a></td>
			<td>${book.updatetime}</td>
			<td width="50">${book.author}</td>
		</tr>
	</c:forEach>

	<tr>
		<td><input type="checkbox" onclick="checkeAll()"  />反选</td>
		<td colspan="5">
		<input type="submit" value="删除" >
		<input type="reset" value="刷新">
		</tr>
	</table>
	</form>
	</div>

    <div class="copyright">
    <p>欢迎进入说天下小说网站阅读，使用中入有任何问题请加 QQ:424255910 或发送邮箱至 uxujiajie@gmail.com</p>
</div><!--copyright结束-->
  </body>
</html>
