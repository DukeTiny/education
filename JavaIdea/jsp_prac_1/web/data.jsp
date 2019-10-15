<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/5
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","wh809919");
        String sql = "Select * FROM stu WHERE sno=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,Integer.parseInt( request.getParameter("sno") ) );
        ResultSet rs = ps.executeQuery();
        rs.next();
    %>
    <form action="edit.jsp">
        <input type="hidden" name="sno" value="<%=rs.getInt(1)%>"/>
        sname:<input type="text" name="sname" value="<%=rs.getString(2)%>"/>
        sgender:<input type="text" name="sgender" value="<%=rs.getString(3)%>"/>
        <button type="submit">确定</button>
    </form>
</body>
</html>
