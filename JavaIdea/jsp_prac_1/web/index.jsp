<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/5
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  language="java" %>
<%@ page import="java.sql.*" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <span align="center" >
    <form action="index.jsp">
        Name:<input type="text" name="fuzzyName">
        Gender:<input type="text" name="fuzzyGender">
        <button type="submit">查询</button>
        <%
            String fuzzyName = request.getParameter("fuzzyName");
            String fuzzyGender = request.getParameter("fuzzyGender");
            if ( fuzzyName!=null && !fuzzyName.trim().equals("") && fuzzyGender!=null && !fuzzyGender.trim().equals("") ){
                out.print("name:"+fuzzyName+"  ");
                out.print("gender:"+fuzzyGender);
            }
        %>
    </form>
    <table align="center" border="1" width="600" cellpadding="0" cellspacing="0">
      <caption>TABLE</caption>
      <tr>
        <th>Sequence</th>
        <th>Sno</th>
        <th>Sname</th>
        <th>Sgender</th>
        <th>Edit</th>
        <th>Delete</th>
      </tr>
      <%
          Class.forName("com.mysql.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","wh809919");
          String sql = "SELECT * FROM stu";
          if ( fuzzyName!=null && !fuzzyName.trim().equals("") ){
              sql = "SELECT * FROM stu WHERE sname LIKE ?";
          }
          if ( fuzzyGender!=null && !fuzzyGender.trim().equals("") ){
              if ( !sql.contains("WHERE") ) sql+="WHERE sgender=?";
              else sql += " AND sgender=?";
          }
          PreparedStatement ps = conn.prepareStatement(sql);
          int count=1;
          if ( fuzzyName!=null && !fuzzyName.trim().equals("") ) {
            ps.setString(count++,"%"+fuzzyName+"%");
          }
          if ( fuzzyGender!=null && !fuzzyGender.trim().equals("") ){
              ps.setString(count++,fuzzyGender);
          }
          ResultSet rs = ps.executeQuery();
        while( rs.next() ){
        %>
        <tr align="center" height="30">
            <td><%= rs.getRow()%></td>
            <td><%= rs.getInt(1)%></td>
            <td><%= rs.getString(2)%></td>
            <td><%= rs.getString(3)%></td>
            <td><button type="button" onclick="location.href='data.jsp?sno=<%=rs.getInt(1)%>'">编辑</button></td>
            <td><button type="button" onclick="location.href='del.jsp?sno=<%=rs.getInt(1)%>'">删除</button></td>
        </tr>
        <%
        }
      %>

    </table>
    <button onclick="location.href='addStu.jsp'">Add Stu</button>
    </span>

  </body>
</html>

