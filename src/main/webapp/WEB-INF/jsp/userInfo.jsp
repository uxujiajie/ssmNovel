<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>个人信息页面</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css" >
    <style type="text/css">
		.bookName a{
			 display:block;/*内联对象需加*/
   			 width:31em;
			 word-break:keep-all;/* 不换行 */
			 white-space:nowrap;/* 不换行 */
			 overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */
			 text-overflow:ellipsis;/* 当对象内文本溢出时显示省略标记(...) ；需与overflow:hidden;一起使用。*/
		}
    .main{
        width: 1000px;
        margin: 0 auto;
    }
    .left{
        width: 300px;
        float: left;
    }

    .left1{
        width:120px;
        float: left;

    }
    .left2{
        width: 180px;
        float: left;   
    }
    .left2 a{
        width: 180px;
        font-size:20px;    
    }
    .left2 p{
        width: 180px;
        font-size:16px;   
    }
    .middle{
        width: 400px;
         float: left;
    }
    .middle p{
        width: 400px;
        font-size: 16px;
    }
    .middle textarea{
        width: 400px;
        
    }
     .middle a{
        width: 80px;
        height: 30px;
        line-height: 30px;
        background: #D8A375;
        text-align: center;
        font-size: 16px;
        display:block;
        color: #fff;
    }
    .right{
        width: 300px;
         float: left;
    }
    .right ul{
        width: 300px;
       list-style-type:none;
       text-align:center;
    }
    .right a{
        width: 80px;
        height: 30px;
        line-height: 30px;
        font-size: 14px;
        display:block;
        background-color: #61DA8C;
        margin: 10px auto;
    }
    </style>
  </head>
  
  <body>
    	<div class="top"></div><!--top结束-->
    	<div class="wrap">
    	<jsp:include page="menu.jsp" />
    	</div>
    <div class="main">
    	<div class="left">
    		<div class="left1">
    
    		</div>
    		<div class="left2">
		    <a href="#">设置个人信息</a>
		    <table>
		    	<tr>
			    	<td>用户名:</td>
			    	<td><c:out value="${sessionScope.user.userName}"></c:out></td>
		    	</tr>
		    	<tr>
			    	<td>昵称:</td>
					<td><c:out value="${sessionScope.user.userPick}"></c:out></td>
		    	</tr>
		    	<tr>
			    	<td>余额:</td>
					<td><c:out value="${sessionScope.user.userBalance}"></c:out></td> 
		    	</tr>
		    	<tr>
			    	<td>电话:</td>
			    	<td><c:out value="${sessionScope.user.userTel}"></c:out></td> 
		    	</tr>
		    	<tr>
			    	<td>邮箱:</td>
			    	<td><c:out value="${sessionScope.user.userEmail}"></c:out></td>
		    	</tr>
		    	
		    </table>
		    </div>
    	</div>

	    <div class="middle">
	        <p>您的评论:</p>
			        <table align="center" border="1">
			    	<tr>
				    	<td align="center">
				    	评论
				    	</td >
				    	<td align="center">
				    	评论时间
				    	</td>
				    	<td>
				    	书名
				    	</td>
			    	<tr>
						<c:forEach items="${userComment}" var="comment">
							<tr>
								<td>
									${comment.comment}
								</td>
								<td>
									<fmt:formatDate value="${comment.commenttime}" pattern="yyyy-MM-dd hh:mm:ss" />
								</td>
								<td>
									<div class="bookName">
										<a href='<%=basePath%>findTheBook/${comment.bookid}'>${comment.book.bookname}</a>
									</div>
								</td>
							<tr>
						</c:forEach>
			    </table>
	    </div>
		    <div class="right">
		    <ul>
		    <li><a href='<%=basePath%>turnWriterPage_haveUser.action'>作家专区</a></li>
		    <li><a href="<%=basePath%>turnUserRack_haveUser.action">我的书架</a></li>
		    </ul>
		    </div>
    </div>


    <div class="copyright">
    <p>欢迎进入说天下小说网站阅读，使用中入有任何问题请加 QQ:424255910 或发送邮箱至 uxujiajie@gmail.com</p>
	</div><!--copyright结束-->
	
	
  </body>
</html>
