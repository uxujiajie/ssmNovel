<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>查看个人评论</title>

  </head>
  
  <body>
  <table border="1" align="center">
    <s:iterator var="c" value="colist">
    	<tr>
	    	<td>
	    	评论
	    	</td>
	    	<td>
	    	评论时间
	    	</td>
	    	<td>
	    	书名
	    	</td>
    	<tr>
    	<tr>
	    	<td>
	    	<s:property value="#c.comm" />
	    	</td>
	    	<td>
	    	<s:property value="#c.commentTime" />
	    	</td>
	    	<td>
	    	<s:property value="#c.book.bookName" />
	    	</td>
    	<tr>
    </s:iterator>
    </table>
  </body>
</html>
