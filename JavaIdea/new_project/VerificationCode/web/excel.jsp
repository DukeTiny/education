<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/16
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function download() {
            location.href="askForDownload.do?method=askForDownload&num="+Math.random()*10;
        }
    </script>
</head>
<body>
    <form action="excel.do?method=uploadExcel" method="post" enctype="multipart/form-data">
        <input type="file" name="excel">
        <button>提交</button>
        <button type="button" onclick="download()">下载</button>
    </form>
</body>
</html>
