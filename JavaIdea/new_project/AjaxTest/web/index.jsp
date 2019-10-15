<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/14
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/core.js"></script>
    <script>

        var xmlObj = new XMLHttpRequest();
        xmlObj.open("post","login.do?uname="+1,true);
        xmlObj.onreadystatechange=function (){
            if( xmlObj.readtState===4 && xmlObj.status===200) {
                innerHTML = xmlObj.responseText;
            }
        };
        xmlObj.send();
        // function checkUnameAjax() {
        //     var XMLHttpObj = new XMLHttpRequest();
        //     XMLHttpObj.open("get","login.do?uname="+document.getElementById("uname").value,true);
        //     XMLHttpObj.onreadystatechange = function () {
        //         if( XMLHttpObj.readyState===4 && XMLHttpObj.status===200 ){
        //             document.getElementById("nameResult").innerHTML = XMLHttpObj.responseText;
        //         }
        //     };
        //     XMLHttpObj.send();
        // }
    </script>
  </head>
  <body>
    UserName<input type="text" name="uname" id="uname"><span id="nameResult"></span><br />

    Age<input type="text" name="age"></span>
    <button type="button" onclick="checkUnameAjax()">Check</button>
  </body>
</html>
