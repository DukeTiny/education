<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/15
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
        <form action="upload.do?method=addStu" method="post" enctype="multipart/form-data">
            <input type="text" name="sname"><br />
            <input type="file" name="sphoto"><br />
            <button>提交</button>
        </form>
  </body>
</html>
