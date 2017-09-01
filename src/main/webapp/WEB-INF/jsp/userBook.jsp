<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
   	<title>作者页面</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css">
    <style type="text/css">
    *{font-size: 16px;}
    .content{
        width: 1000px;
        margin: 0 auto;
    }
    .content h1{
        
        height: 50px;
        line-height: 50px;
        font-size: 20px;
        text-align:center;
        
    }
    .content table{
        width: 1000px;
        text-align:center;
    }
    .content td{
        font-size:16px;
        text-align:center;
    }
    .content p{
        font-size:14px;
        text-align:center;
    }
    .content a{
        width:70px;
        height: 30px;
        line-height: 30px;
        text-align: center;
        font-size:14px;
        background: #7FB3D2;
        color: #fff;
        display:inline-block;
    }
    .content1{
        width: 1000px;
        margin: 0 auto;
            }
    .content1 a{
        width:80px;
        height: 35px;
        line-height: 35px;
        text-align: center;
        font-size:16px;
        background: #3D8CD9;
        color: #fff;
        display:inline-block;
        margin: 10px 200px;
    }
    .content2 h1{
        width: 1000px;
        font-size:20px;
        text-align: center;
        margin: 20px auto;
            }
    .content2 table{
        width: 1000px;
        margin: 0 auto;
    }
    .content2 td{
        text-align: center;
    }
    .content2_tr{
        height: 30px;
        text-align: center;
        background: #87D289;
    }
    .content2_td{
        width: 300px;
        height: 30px;
        font-size:14px;
        text-align: center;
        background: #CBD8D5;
    }
    </style>
  </head>
  
  <body>
    	
    	<div class="wrap">
    	<jsp:include page="menu.jsp" />
    	</div>
    	
    	<div class="content">
    	<h1>作品管理</h1>
	    <table>
		    <tr>
			    <td width="50px">书名</td>
			    <td width="150px">上次更新时间</td>
			    <td width="250px">操作</td>
		    </tr>
			<c:forEach items="${requestScope.writerBooks.bookList}" var="wriBook">
	    		<tr>
				    <td>${wriBook.bookname} </td>
				    <td><fmt:formatDate value="${wriBook.updatetime}" type="both" /> </td>
			    	<td>
				    	<a href='<%=basePath%>turnWriteSec_haveUser/${wriBook.id}'>写新章节</a>
				    	<a href='${pageContext.request.contextPath  }/writer_writerBookSec.action?bookId=<s:property value="#userBook.bookId" />'>查看章节</a>
		    		</td>
	    		</tr>
			</c:forEach>
	    </table>
    
    </div>
    <div class="content1">
    	<a href='<%=basePath%>turnWriteBook_haveUser.action'>新建作品</a>
    </div>
    

    <div class="copyright">
    <p>欢迎进入说天下小说网站阅读，使用中入有任何问题请加 QQ:424255910 或发送邮箱至 uxujiajie@gmail.com</p>
    </div>
  </body>
</html>