<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>蜗牛商店，欢迎选购</title>
    <style>
        body{
            margin: 0;
            background-color: rgba(240,240,240,1);
            overflow: hidden;
        }
        .nav{
            margin: 0;
            background-color: rgba(0,0,0,0.8);
            border-bottom: 1px solid gray;
            height: 50px;
        }
        .nav div:first-child{
            width: 16%;
            height: 20px;
            float: left;
        }
        .nav div:nth-child(2){
            width: 10%;
            line-height: 50px;
            color: lightgray;
            float: left;
        }
        .nav div:nth-child(4){
            width: 35%;
            height: 50px;
            line-height: 50px;
            text-align: center;
            color: lightgray;
            float: left;
        }
        .nav div:nth-child(5){
            width: 15%;
            height: 50px;
            line-height: 50px;
            color: lightgray;
            float: left;
        }
        .nav a{
            line-height: 50px;
            color: lightgray;
            float: left;
        }
        a:link,a:visited{
            text-decoration: none;
        }
        a:hover,a:active{
            color: orange;
        }
        iframe{
            width: 100%;
            height: 1500px;
            border: none;
            margin: 0;
            padding: 0;
            display: block;
        }
    </style>
</head>
<body>
    <div class="nav">
        <div></div>
        <div>欢迎${sessionScope.loginUser.username}登录&nbsp;&nbsp;&nbsp;</div>
        <div style="width: 17%;float: left"><a href="login.do?method=quit"><font color="orange">退出</font></a></div>
        <div>
            <a href="manageType.jsp" target="content" >类型信息&nbsp;&nbsp;|&nbsp;&nbsp; </a>
            <a href="manageProduct.jsp" target="content">商品信息&nbsp;&nbsp;|&nbsp;&nbsp;</a>
            <a href="manageStock.jsp" target="content">进货信息&nbsp;&nbsp;|&nbsp;&nbsp;</a>
            <a href="addInformation.jsp" target="content">添加信息</a>
        </div>
        <div>
            <form action="query.do" method="post">
                <input type="text" name="search" style=" color:lightcyan; width:150px; margin-top: 14px; line-height: 18px;  background:rgba(0,0,0,0); border:1px gray solid; border-radius: 3px " placeholder="搜索" />
                <button style="width:40px; margin-top:-20px;margin-left:160px; background: orangered; color:rgba(230,230,230,1); border:none; border-radius: 3px;">搜索</button>
            </form>
        </div>
        <div></div>
    </div>
    <hr style="height:1px; border:none;border-top:1px solid black; margin:0;" size="0" >
    <iframe src="${sessionScope.loginUser.userRole=="管理员"?"welcome.html":"customer_Content.jsp"}" name="content" frameborder= "0" ></iframe>

</body>
</html>
