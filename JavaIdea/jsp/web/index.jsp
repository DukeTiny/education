<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/3
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%
      for ( int i=0; i<=9; i++ ){
        for ( int j=0; j<=i; j++ ){
          out.print(i+"*"+j+"="+i*j+"&nbsp;&nbsp;&nbsp;");
        }
        out.print("<br />");

      }
    %>
    <form method="get" action="another_jsp.jsp">
      <input type="text" name="uname">
      <input type="checkbox" name="hobbies" value="电影"/>电影
      <input type="checkbox" name="hobbies" value="读书"/>读书
      <input type="checkbox" name="hobbies" value="玩耍"/>玩耍
      <button>提交</button>
    </form>
  </body>
</html>
