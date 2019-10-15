<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/6/25
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>G.jsp</title>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script>
        $(document).ready(function () {
            $("#btn").click(function () {
                $.ajax({
                    type:"post",
                    url:"user/f1.do",
                    data:"{\"id\":250,\"name\":\"Duke\",\"birthday\":\"1990/8/19\"}",
                    contentType:"application/json"
                });
            });
            $("#btn2").click(function () {
                $.ajax({
                    type:"post",
                    url:"user/f4.do",
                    headers:{
                        "Accept":"cxz/Duke"
                    },
                    success:function (data) {
                        alert(data);
                    }
                });
            })
        });
    </script>
</head>
<body>
    <button type="button" id="btn">Let's go</button>
    <hr />
    <button type="button" id="btn2">Let's go</button>
</body>
</html>
