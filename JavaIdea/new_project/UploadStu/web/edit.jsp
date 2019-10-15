<%@ page import="com.sia.bean.Stu" %><%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/15
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script>
        function changePhoto(event) {
            var file = event.target.files[0];
            var imgUrl = window.URL.createObjectURL(file);
            document.getElementById("preview").setAttribute("src",imgUrl);
        }
    </script>
</head>
<body>
    <%
        Stu stu = (Stu) request.getAttribute("stu");
    %>
    <form action="upload.do?method=editStu" method="post" enctype="multipart/form-data">
        <input type="hidden" name="sid" value="<%=stu.getSid()%>" />
        用户名:<input type="text" name="sname" value="<%=stu.getsName()%>" />
        你的片:<img id="preview" src="<%=request.getContextPath()+stu.getsPhoto()%>" style="width: 50px;" />
        <input type="file" name="sphoto" onchange="changePhoto(event)"/>
        <button>提交</button>
    </form>
</body>
</html>
