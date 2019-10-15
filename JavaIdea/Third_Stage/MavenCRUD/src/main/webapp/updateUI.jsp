<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Add New User</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap-grid.min.css" rel="stylesheet">
    <style>

    </style>
</head>
<body>
    <form action="User_save" method="post">
    <table align="center">
        <tr>
            <td>id:<input type="hidden" value="${requestScope.user.id}" name="username" /><td>
            <td>Username:<input type="text" value="${requestScope.user.username}" name="username" /><td>
            <td>Birthday:<input type="text" value="${requestScope.user.birthday}" name="birthday" /></td>
            <td>Money:<input type="text" value="${requestScope.user.money}" name="money" /></td>
            <td><button>Submit</button></td>
        </tr>
    </table>
    </form>
</body>
</html>
