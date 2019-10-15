<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
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

        .nav div:nth-child(2){
            line-height: 30px;
            color: lightgray;
            float: left;
            position: inherit;
            right: 22%;
        }

        .nav div:last-child{
            line-height: 30px;
            /*text-align: center;*/
            color: lightgray;
            float: left;
            position: inherit;
            right: 19%;
        }


        a:link,a:visited{
            line-height: 30px;
            color: rgba(250,250,250,1);
            text-decoration: none;
            float: left;
            position: inherit;
        }

        a:hover,a:active{
            line-height: 30px;
            color: rgba(255,255,0,1);
            text-decoration: none;
            float: left;
            position: inherit;
        }
        input{
            margin-top: 12px;
            margin-left: 50px;
            width: 150px;
            height: 25px;
            text-indent:10px;
            border-radius: 5px;
            border: none;
            outline: none;
        }
        button{
            /*margin-top: -5px;*/
            width: 40px;
            height: 24px;
            color: orangered;
            border-radius: 5px;
            background: white;
            border: none;
            outline: none;
            font-size: 12px;
            font-family: "思源黑体 CN", "微软雅黑";
        }

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
            height: 280px;
            background-color: white;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 0 3px 1px rgba(0,0,0,0.15);
        }

        .imgContent{
            height: 200px;
        }

        .brandContent{
            float: left;
            margin-left: 10px;
            margin-top: 5px;
            line-height: 18px;
            width:100%;
            font-size: 10px
        }

        .nameContent{
            margin-left: 10px;
            color: gray;
            font-size: 1px;
        }

        .add{
            text-align: right;
            float: right;
            width: 40px;
            height: 25px;
            border-radius: 5px;
            margin-right: 10px;
            margin-top: 5px;
            color: white;
            font-size: 4px;
            border: none;
            outline: none;
            background-color: orange;
        }
        .add:hover{
            box-shadow: 0 0 2px 1px rgba(0,0,0,0.1);
        }


        .priceContent{
            margin-left:10px;
            width: 50px;
            margin-top: 5px;
            line-height: 24px;
            color: orangered
        }

        #type{
            margin: 40px auto 0;
            width: 60.5%;
            height: 50px;
            color: gray;
            background-color: orangered;
            border-radius: 5px;
            box-shadow: 0 0 3px 1px rgba(0,0,0,0.15);
        }

        li{
            margin-top: 10px;
            list-style-type: none;
            float: left;
            margin-left: 15px;
        }
        li:first-child{
            font-size: 21px;
            color: white;
            padding-right: 30px;
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
        <div>
            <a href="login.html">登录</a>
        </div>
        <div><a href="quit.do">退出</a></div>
    </div>
    <div id="type" >
        <ul>
            <li><strong>品牌</strong></li>
            <li><a href="">啄木鸟</a></li>
            <li><a href="">|</a></li>
            <li><a href="">耐克</a></li>
            <li><a href="">|</a></li>
            <li><a href="">阿迪达斯</a></li>
            <li><a href="">|</a></li>
            <li><a href="">锐步</a></li>
            <li><a href="">|</a></li>
            <li><a href="">李宁</a></li>
            <li><a href="">|</a></li>
            <li><a href="">匡威</a></li>
            <li><a href="">|</a></li>
            <li><a href=""><em>HM</em></a></li>
        </ul>
        <input type="texts" placeholder="搜索"/>
        <button type="button">搜索</button>
    </div>
    <div id="boxWrapper">
        <div class="boxContent">
            <img src="./img/loginBG.jpg" class="imgContent">
            <div class="brandContent">CocaCola</div>
            <div class="nameContent">超级好喝的可口可乐</div>
            <button class="add">添加</button>
            <div class="priceContent">Price</div>
        </div>
        <div class="boxContent">
            <img src="./img/loginBG.jpg" class="imgContent">
            <div class="brandContent">CocaCola</div>
            <div class="nameContent">超级好喝的可口可乐</div>
            <button class="add">添加</button>
            <div class="priceContent">Price</div>
        </div>
        <div class="boxContent">
            <img src="./img/loginBG.jpg" class="imgContent">
            <div class="brandContent">CocaCola</div>
            <div class="nameContent">超级好喝的可口可乐</div>
            <button class="add">添加</button>
            <div class="priceContent">Price</div>
        </div>
        <div class="boxContent">
            <img src="./img/loginBG.jpg" class="imgContent">
            <div class="brandContent">CocaCola</div>
            <div class="nameContent">超级好喝的可口可乐</div>
            <button class="add">添加</button>
            <div class="priceContent">Price</div>
        </div>
        <div class="boxContent">
            <img src="./img/loginBG.jpg" class="imgContent">
            <div class="brandContent">CocaCola</div>
            <div class="nameContent">超级好喝的可口可乐</div>
            <button class="add">添加</button>
            <div class="priceContent">Price</div>
        </div>
        <div class="boxContent">
            <img src="./img/loginBG.jpg" class="imgContent">
            <div class="brandContent">CocaCola</div>
            <div class="nameContent">超级好喝的可口可乐</div>
            <button class="add">添加</button>
            <div class="priceContent">Price</div>
        </div>
        <div class="boxContent">
            <img src="./img/loginBG.jpg" class="imgContent">
            <div class="brandContent">CocaCola</div>
            <div class="nameContent">超级好喝的可口可乐</div>
            <button class="add">添加</button>
            <div class="priceContent">Price</div>
        </div>
        <div class="boxContent">
            <img src="./img/loginBG.jpg" class="imgContent">
            <div class="brandContent">CocaCola</div>
            <div class="nameContent">超级好喝的可口可乐</div>
            <button class="add">添加</button>
            <div class="priceContent">Price</div>
        </div>
        <div class="boxContent">
            <img src="./img/loginBG.jpg" class="imgContent">
            <div class="brandContent">CocaCola</div>
            <div class="nameContent">超级好喝的可口可乐</div>
            <button class="add">添加</button>
            <div class="priceContent">Price</div>
        </div>
        <div class="boxContent">
            <img src="./img/loginBG.jpg" class="imgContent">
            <div class="brandContent">CocaCola</div>
            <div class="nameContent">超级好喝的可口可乐</div>
            <button class="add">添加</button>
            <div class="priceContent">Price</div>
        </div>
        <div class="boxContent">
            <img src="./img/loginBG.jpg" class="imgContent">
            <div class="brandContent">CocaCola</div>
            <div class="nameContent">超级好喝的可口可乐</div>
            <button class="add">添加</button>
            <div class="priceContent">Price</div>
        </div>
        <div class="boxContent">
            <img src="./img/loginBG.jpg" class="imgContent">
            <div class="brandContent">CocaCola</div>
            <div class="nameContent">超级好喝的可口可乐</div>
            <button class="add">添加</button>
            <div class="priceContent">Price</div>
        </div>
    </div>

    <div id="bottom">
        ©&nbsp;&nbsp;&nbsp;成都蜗牛畅想学院&nbsp;&nbsp;&nbsp;西安校区&nbsp;&nbsp;&nbsp;第十二期六组王虎&nbsp;&nbsp;&nbsp;®
    </div>
</body>
</html>