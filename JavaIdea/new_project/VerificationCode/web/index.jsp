<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/16
  Time: 09:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script>
        function changeVC() {
            // document.getElementById("vc").src="vc.do?time="+new Date().getTime();
            document.getElementById("vc").src="vc.do?"+Math.random()*10+1;
        }
    </script>
  </head>
  <body>
  <%
    request.setAttribute("uname","Duke");
    request.setAttribute("uname","Tiger");
    request.setAttribute("uname","Joe");
  %>
    <form action="login.do?" method="get" enctype="">
        <img src="vc.do" alt="Verification Code" id="vc" onclick="changeVC()">
        <input type="text" name="vc"/>
        <button>提交</button>
    </form>
  </body>
</html>
