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
    <title>说天下</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css">
      <link rel="shortcut  icon" type="image/x-icon" href="<%=basePath%>images/index.ico" media="screen"  />
  </head>
  
  <body>
    <div class="wrap">
	    	<jsp:include page="menu.jsp" />
    <div class="search">
	    <div class="search_left">
	    <img src="<%=basePath%>images/LOGO03.png" width="200" height="90">
	    </div>
	    <div class="search_right"> 
		    <div class="search_middle">
		          <form action="findByAuthorOrName" method="post">
		          <input type="text" name="authorOrName" class="search_text"  placeholder="请输入作者或书名">
		          <input type="submit" value="搜索">
		          </form>
		    </div>
		    <div class="search_inright">
            <a href="<%=basePath%>turnUserRack_haveUser.action">我的书架</a>
		    </div>
	    </div>
    </div>
    
    <div class="fenlei">
    <div class="one">
    <a href="#">作品分类>></a>
    </div>
    <div class="two">
        <table>
	        <tr>
		        <c:forEach var="cate" varStatus="mar" items="${categoryList}" >
		  		<td><a href="<%=basePath%>findFirCateOfBook/${cate.id}"> ${cate.catename}</a></td>
			  		<c:choose>
                        <c:when test="${mar.count % 6 == 0}">
                            </tr><tr>
                        </c:when>
                    </c:choose>
		  		</c:forEach>
	        </tr>
        </table>
    </div>
    </div>
    <div class="scrollnews">
        <div class="scrollnews_left"><a href="<%=basePath%>findAllByPageHits.action">全部推荐>></a> </div>
    </div><!--scrollnews结束-->
    <div class="course">
        <table >
         	<tr>
                <c:forEach items="${bookList}" varStatus="mar"  var="book">
                    <td>
                        <img src="<%=picPath%>${book.bookimage}" width="325px" height="280px" >
                        <a href="<%=basePath%>findTheBook/${book.id}"> <c:out value="${book.bookname}"></c:out></a>
                    </td>
                    <c:choose>
                        <c:when test="${mar.count % 3 == 0}">
                            </tr><tr>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </tr>
           </table>
<div class="copyright">
    <p>欢迎进入说天下小说网站，使用中入有任何问题请加 QQ:424255910 或发送邮箱至 uxujiajie@gmail.com</p>
</div><!--copyright结束-->
</div><!--wrap结束-->
</div>
</body>
  </body>
</html>
