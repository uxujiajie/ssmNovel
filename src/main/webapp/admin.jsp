<%--
  Created by IntelliJ IDEA.
  User: xu
  Date: 2017/8/3
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>后台登录界面</title>
</head>
<body>
    <form action="loginAdmin" method="post">
        管理名:<input type="text" name="adUser" > <br>
        口令:<input type="text" name="adPass" > <br>
        附加码:<input type="text" name="roleId"> <br>
        <input type="submit" value="提交" >
    </form>
    <a href="<%=basePath%>turnAdminPage.action">管理员</a>
</body>
</html>
