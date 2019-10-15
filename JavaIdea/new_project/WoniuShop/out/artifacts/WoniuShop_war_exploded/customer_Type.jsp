<%@ page import="com.cxz.po.Role" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>蜗牛商店，欢迎选购</title>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script>
    </script>

    <style>

        body{
            margin: 0;
        }

        .nav{
            margin: 0;
            width: 100%;
            background-color: rgba(0,0,0,0.8);
            border-bottom: 1px solid gray;
            height: 30px;
            position: fixed;
            top: 0;
        }

        .nav div:first-child{
            margin-left: 20%;
            float: left;
            color: white;
            font-family: Copperplate;
            line-height: 30px;
        }

        .test{
            line-height: 30px;
            color: lightgray;
            float: left;
            position: absolute;
            right: 500px;
        }

        .nav div:last-child{
            line-height: 30px;
            /*text-align: center;*/
            color: lightgray;
            float: left;
            position: inherit;
            right: 160px;
        }
        .nav a{
            line-height: 30px;
            color: lightgray;
            text-decoration: none;
            float: left;
            position: inherit;
        }

        input{
            width: 100px;
            height: 20px;
            text-align: center;
        }
        /*button{*/
            /*width: 500px;*/
            /*height: 50px;*/
            /*color: white;*/
            /*border-radius: 10px;*/
            /*background: darkorange;*/
            /*border: none;*/
            /*font-size: 18px;*/
            /*font-family: "思源黑体 CN", "微软雅黑";*/
        /*}*/

        #boxWrapper{
            margin:auto;
            width: 61.3%;
        }
        .boxContent{
            margin-top: 10px;
            margin-left: 5px;
            margin-right: 5px;
            float: left;
            width: 210px;
            height: 140px;
            background-color: white;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 0 3px 1px rgba(0,0,0,0.15);
        }

        .left{
            height: 110px;
            width: 210px;
            border-bottom: 1px orangered solid;
        }
        .right{
            width: 210px;
            height: 30px;
        }
        .typeContent{
            margin-left: 15px;
            margin-top: 2px;
            font-size: 18px;
            line-height: 24px;
            float: left;
        }

        .nameContent{
            margin-right: 10px;
            margin-top: 7px;
            color: gray;
            font-size: 10px;
            float: right;
        }

        #slideshow{
            margin: 30px auto 0;
            width: 100%;
            height: 500px;
            border: 1px orangered solid;
        }

        #bottom{
            border-top: 1px lightgray solid;
            width: 100%;
            float: left;
            margin-top: 10px;
            text-align: center;
            color: lightgray;
            font-size: 10px;
            line-height: 30px;
        }

    </style>
</head>
<body>
    <div class="nav">
        <div><a href="customer_Type.jsp">WONIU</a></div>
        <%
            Role role = (Role)session.getAttribute("loginUser");
            if( role!=null ){
                out.println("<div class=\"test\"><a href=\"login.html\">登录</a></div>");
                out.println("<div><a href=\"quit.do\">退出</a></div>");
            }
            else {
                out.print("<div><a href=\"login.html\">登录</a></div>");
            }
        %>
    </div>
    <div id="slideshow" >
    </div>
    <div id="boxWrapper">
        <div class="boxContent">
            <div><img src="./img/loginBG.jpg" class="left"></div>
            <div class="right">
                <div class="typeContent">上衣</div>
                <div class="nameContent">短袖、长袖、外套等</div>
            </div>
        </div>
        <div class="boxContent">
            <div><img src="./img/loginBG.jpg" class="left"></div>
            <div class="right">
                <div class="typeContent">上衣</div>
                <div class="nameContent">短袖、长袖、外套等</div>
            </div>
        </div>
        <div class="boxContent">
            <div><img src="./img/loginBG.jpg" class="left"></div>
            <div class="right">
                <div class="typeContent">上衣</div>
                <div class="nameContent">短袖、长袖、外套等</div>
            </div>
        </div>
        <div class="boxContent">
            <div><img src="./img/loginBG.jpg" class="left"></div>
            <div class="right">
                <div class="typeContent">上衣</div>
                <div class="nameContent">短袖、长袖、外套等</div>
            </div>
        </div>
    </div>
    <br />
    <div id="bottom">
        ©&nbsp;&nbsp;&nbsp;成都蜗牛畅想学院&nbsp;&nbsp;&nbsp;西安校区&nbsp;&nbsp;&nbsp;第十二期六组王虎&nbsp;&nbsp;&nbsp;®
    </div>
</body>
</html>