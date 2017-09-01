<%--
  Created by IntelliJ IDEA.
  User: xu
  Date: 2017/8/1
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>上传小说</title>
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        function testPattern() {
            var pattern = $("#pattern").val();
            var context = $("#context").val();
            if(pattern.length <=0 || context.length <=0) {
                alert("请输入校验规则");
                return;
            }
            $.ajax({
                type:'post',
                url:'<%=basePath%>validateSec.action',
                data:'pattern='+pattern+"&context="+context,
                success : function (data) {
                    $("#patternResult").empty();
                    $("#patternResult").append(data);
                }
            });
        }
    </script>
</head>
<body>
    <form action="uploadNovel" method="post" enctype="multipart/form-data">
        小说 :  <input name="novel" type="file">
        <br>
        小说id : <input name="bookId" type="number" min="1" >
        <br>
        验证规则 : <input id="pattern"  name="pattern" type="text">(不填默认使用"^.*第.*章\\s*.*$")
        <br>
        <input type="submit" value="上传小说">
    </form>
    <hr>
    验证内容 : <input id="context" name="context" type="text">
    <br>
    <input type="button" value="校验" onclick="testPattern()">
    <br>
    <p id="patternResult" ></p>

    <hr>
    <img src="<%=basePath%>images/zz1.png" />
    <img src="<%=basePath%>images/zz2.png" />
    <img src="<%=basePath%>images/zz3.png" />
    <img src="<%=basePath%>images/zz4.png" />

</body>
</html>
