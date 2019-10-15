<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>L.jsp</title>
</head>
<body>
    <h3>L.jsp</h3>

    <form action="/user/save.do"  method="post">
        <lable>id:<input name="id" value="${user.id}"/>${idError}</lable> <br />
        <lable>name:<input name="name" value="${user.name}"/>${nameError}</lable> <br />
        <lable>birthday:<input name="birthday" value="<fmt:formatDate value="${user.birthday}" pattern="yyyy/MM/dd"/>"/>${birthdayError}</lable> <br />
        <label>money:<input name="money" value="${user.money}"/>${moneyError}</label> <br />
        <button>Go</button>
    </form>
    <hr />
    <form action="/user/update.do"  method="post">
        <lable>id:<input name="id" value="${user.id}"/>${idError}</lable> <br />
        <lable>name:<input name="name" value="${user.name}"/>${nameError}</lable> <br />
        <lable>birthday:<input name="birthday" value="<fmt:formatDate value="${user.birthday}" pattern="yyyy/MM/dd"/>"/>${birthdadError}</lable> <br />
        <label>money:<input name="money" value="${user.money}"/>${moneyError}</label> <br />
        <button>Go</button>
    </form>

</body>
</html>
