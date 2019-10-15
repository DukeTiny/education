<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/10
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
        <table width="800" align="center" border="1" cellspacing="1" cellpadding="5" >
            <tr>
                <th>序号</th>
                <th>员工ID</th>
                <th>员工姓名</th>
                <th>职位</th>
                <th>领导</th>
                <th>入职日期</th>
                <th>薪水</th>
                <th>奖金</th>
                <th>部门号</th>
            </tr>
            <c:forEach var="emp" items="${requestScope.emps}" varStatus="status">
                <tr align="center" bgcolor="${(status.index+1)%2==0?'#f0f8ff':'white'}" >
                    <td height="40">${status.index+1}</td>
                    <td>${emp.empno}</td>
                    <td>${emp.ename}</td>
                    <td>${emp.job}</td>
                    <c:forEach var="emp2" items="${requestScope.emps}">
                        <c:if test="${emp2.empno==emp.mgr}">
                            <td>${emp2.ename}</td>
                        </c:if>
                    </c:forEach>
                    <c:if test="${emp.mgr==''}">
                        <td>I'Am ALpha</td>
                    </c:if>
                    <td>${emp.hiredate}</td>
                    <td>${emp.sal}</td>
                    <td>${emp.comm}</td>
                    <c:forEach var="dept" items="${requestScope.depts}">
                        <c:if test="${emp.deptno==dept.deptno}">
                            <td>${dept.dname}</td>
                        </c:if>
                    </c:forEach>
                </tr>
            </c:forEach>
            <tr>
                <td height="60" colspan="9" bgcolor="#1e90ff" onclick="location.href='empServlet.do?method=addEmpWindow'" align="center">
                    <font color="#e0ffff" size="5">添加员工</font>
                </td>
            </tr>
        </table>
  </body>
</html>
