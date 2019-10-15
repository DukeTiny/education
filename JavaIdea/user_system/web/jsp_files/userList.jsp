<%@ page import="java.util.List" %>
<%@ page import="com.sia.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/7
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>UserList</title>
  </head>
  <body>
        <%
            List<User> users = (List<User>) session.getAttribute("users");
        %>
        <table align="center" width="500">
            <tr>
                <td>序号</td>
                <td>用户ID</td>
                <td>用户名</td>
                <td>用户密码</td>
                <td>用户角色</td>
                <td>用户状态</td>
            </tr>
            <%
                for( int i=0; i<users.size(); i++ ){
                    User user = users.get(i);
                    %>
                    <tr height="30">
                        <td><%= (i+1)%></td>
                        <td><%= user.getUid()%></td>
                        <td><%= user.getUname()%></td>
                        <td><button type="button" onclick="location.href='managerChangeUserPass.jsp?<% session.setAttribute("uname",user.getUname());session.setAttribute("upwd",user.getUpwd());%>'">重置密码</button></td>
                        <td><%= user.getUrole()%></td>
                        <td><%= user.getUstatus()%></td>
                        <td><button type="button" onclick="location.href='../changeUserStatus.do?<% session.setAttribute("uname",user.getUname());session.setAttribute("upwd",user.getUpwd());%>'"><%=(user.getUstatus().equalsIgnoreCase("normal")?"冻结账户":"解冻账户")%></button></td>
                    </tr>
                    <%
                }
            %>
        </table>
  </body>
</html>
