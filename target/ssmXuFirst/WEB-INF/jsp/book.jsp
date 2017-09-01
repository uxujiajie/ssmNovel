<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String picPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"//pic";
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
   	 <title>书的简介</title>
	  <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js" ></script>
	  <script type="text/javascript">
          function userComment() {
              var  comment = $("#aComment").val();
              if(comment.length < 6 || comment.length>50)
			  	{
			      alert("评论长度应该大于6小于50");
			      return;
			  	}
              var bookId = $("#aBookId").val();
              $.ajax({
                  type: 'post',
                  url: '<%=basePath%>addCommentByUser.action',
                  data: "comment="+comment+"&bookid="+bookId,
                  success: function (data) {
                      alert(data);
                  }
              });
          }
	  </script>
	 <link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css">
	  <style type="text/css">
	.secName a{
			 display:block;/*内联对象需加*/
			font-size: small;
   			 width:199px;
			 word-break:keep-all;/* 不换行 */
			 white-space:nowrap;/* 不换行 */
			 overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */
			 text-overflow:ellipsis;/* 当对象内文本溢出时显示省略标记(...) ；需与overflow:hidden;一起使用。*/
		}
	.b{
		width: 1000px;
		height: 250px;
        margin: 10px auto;
	}
    .b img{
        margin: 10px auto;
        display:block;
    }
	.d{
		font-size: 16px;
        text-align:center;
	}
    .book-info{
        width: 500px;
        height: 30px;
        margin: 0 auto;
        padding: 10px 400px; 
        } 
    .tag1 span {
    display: inline-block;
    overflow: hidden;
    height: 25px;
    line-height:25px; 
    padding: 0 10px;
    text-align: center;
    vertical-align: middle;
    border-width: 1px;
    border-style: solid;
    border-color: #13C1E8;
    border-radius: 15px;
	}
    .tag2 p{
        width: 1000px;
 display: inline-block;
 text-align:center ;
 font-size: 18px;
    }
    .tag3 h1{
        width: 1000px;
 display: inline-block;
 text-align:center ;
 font-size: 18px; 
    }
	.d h1{
		font-size: 20px;
	}
    .c{
        width: 1000px;
        height: 60px;
        margin: 0 auto;
    }
	.g{
		width:200px;
		height: 50px;
		line-height: 50px;
        margin: 10px 148px;
	    display:inline-block;
	    text-align: center;
	    background: #BD3847;
	}
	.g a{
		text-decoration:none;
		color:  #FFFFFF; }
	.h{
		width:200px;
		height: 50px;
		line-height: 50px;
	    margin: 10px 148px;
	    display:inline-block;
	    text-align: center;
	    background: #BD3847;
	}
	.h a{
		text-decoration:none;
		color:  #FFFFFF; }
	.i{
				width:1000px;
				height: 40px;
				line-height:40px;
				margin: 10px auto;
				font-size: 30px;
	text-align: center;
	background:#B98A90;
	}
    .x p{
        font-size: 20px;
	text-align: center;
	}
    .j{
		width:1000px;
		height: 40px;
		line-height:40px;
		font-size: 30px;
		margin: 10px auto ;
	text-align: center;
	background: #B98A90;
	}
	.two{
	    margin:0 auto;
	}
    .pl h1{
        width: 1000px;
        font-size: 20px;
        text-align: center;
        margin: 50px auto;
    }
    .pl table{
        width: 1000px; 
        text-align: center;

    }
	</style>
  </head>
  
  <body>
	  <div class="wrap">
	    <jsp:include page="menu.jsp" />
	    
		    <div class="b">
<img src='<%=picPath%>${book.bookimage}' alt='${book.bookname}' width="800" height="500" />
	    <div>
	    <div class="d">
	    <p><h1>${book.bookname}</h1><br><a href="" target="_blank" >${book.author} </a> 著
	    </div>
	    <div class="book-info ">
	        <div>
	         <p class="tag1">
				 <c:forEach items="${book.categoryList}" var="cate">
					 <span><a href="<%=basePath%>findFirCateOfBook/${cate.id}">${cate.catename}</a></span>
				 </c:forEach>
	        </p>
	        </div>  
	        </div>
	        <div class="tag2">
				<P >点击数${book.hits}</P>
	        </div>
	    <div class="c">
	    <div class="g">
	    <span>
			<c:choose>
				<c:when test="${book.sectionList.size() == 0}">
					作者还没有更新章节哦!!!
				</c:when>
				<c:otherwise>
					<a href="<%=basePath%>lookSecContent?secNumId=1&bookId=${book.id}">点击阅读</a>
				</c:otherwise>
			</c:choose>
	    </span>
	    </div>
			<c:set var="us" value="0" />
			<c:choose>
				<c:when test="${user != null}">
					<c:forEach items="${user.bookList}" var="userbook">
						<c:choose>
							<c:when test="${userbook.id == book.id}">
								<c:set var="us" value="1" />
							</c:when>
						</c:choose>
					</c:forEach>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${us == 1}">
					<div class="h"><span>已在书架</span>
					</div>
				</c:when>
				<c:otherwise>
					<div class="h"><span><a href='<%=basePath%>addRack_haveUser/${book.id}'>加入书架</a></span>
					</div>
				</c:otherwise>
			</c:choose>
	    </div>
	    </div>
	
	    <div class="i">作品信息</div>
	    <div class="x" >　
	    	<p>${book.intro}</p>
	    </div>
	     <div class="j">目录</div>
				<a href="<%=picPath%>/${book.bookurl}sayNovel.zip">点击下载小说</a>
				<hr>
	     <div class="two">
	        <table>
	        <tr>
				<c:choose>
					<c:when test="${book.booknum.size() == 0}">
						<td>作者还没有更新章节哦!!!</td>
					</c:when>
					<c:otherwise>
						<c:forEach items="${book.sectionList}" var="section" varStatus="mar">
							<td class="secName"><a href='<%=basePath%>lookSecContent?secNumId=${section.sectionnum}&bookId=${book.id}'>${section.sectiontitle}</a> </td>
							<c:choose>
								<c:when test="${mar.count % 5 == 0}">
									</tr><tr>
								</c:when>
							</c:choose>
						</c:forEach>
					</c:otherwise>
				</c:choose>
	        </tr>
	        </table>
	    </div>
	    <div class="pl">
	    <h1>书友评价</h1>
	    <table  cellspacing="0" >
			<c:choose>
				<c:when test="${book.commentExamList.size() == 0}">
					<td width="1000" height="50">还没有人发表评论,赶紧抢沙发吧</td>
				</c:when>
				<c:otherwise>
					<tr>
						<td>内容</td>
						<td>时间</td>
						<td>用户</td>
					</tr>
					<c:forEach items="${book.commentExamList}" var="comment">
						<tr>
							<td>${comment.comment}</td>
							<td><fmt:formatDate value="${comment.commenttime}" type="both" /></td>
							<td>${comment.user.userName}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
	    </table>
		   
		    	<input id="aComment" type="text"  name="comment">
		    	<input id="aBookId" type="hidden" name="bookid" value='${book.id}' >
		    	<input type="button" onclick="userComment();" value="我要评价">

		   
	    </div>

	    <div class="copyright">
	    <p>欢迎进入说天下小说网站，使用中入有任何问题请加 QQ:424255910 或发送邮箱至 uxujiajie@gmail.com</p>
		</div><!--copyright结束-->
	</div>
	</div>
		    
  </body>
</html>
