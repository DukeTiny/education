<%@ page import="java.util.List" %>
<%@ page import="com.sia.bean.Stu" %>
<%@ page import="com.sia.service.ServiceFactory" %><%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/15
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script>
        $(document).ready(function () {
            $.post("upload.do",{"method":"getAll"},function (data,status) {
                datas = eval('('+data+')');
                showAll(datas);
            });
            function showAll(datas) {
                var tBody = $("#tBody");
                tBody.empty();
                $.each(datas,function (index,stu) {
                    var tr = $("<tr align='center'></tr>");
                    tr.append($("<td>"+(index+1)+"</td>"));
                    tr.append($("<td>"+stu.sid+"</td>"));
                    tr.append($("<td>"+stu.sName+"</td>"));
                    tr.append($("<td><img width='50' src='"+"<%=request.getContextPath()%>"+stu.sPhoto+"'</td>"));
                    var edit = $("<button type='button'>编辑</button>");
                    edit.click(function () {
                        location.href = "upload.do?method=askEditStu&sid=" + stu.sid
                    });
                    tr.append($("<td></td>").append(edit));
                    var del = $("<button type='button'>Delete</button>");
                    del.click(function () {
                        $.post("upload.do",{"method":"delStu","sid":stu.sid},function (d,status) {
                            datass = eval('('+d+')');
                            showAll(datass);
                        });
                    });
                    tr.append($("<td></td>").append(del));
                    tBody.append(tr);
                });
            }
        });


    </script>
</head>
<body>
<table width="800" align="center" border="1"cellpadding="10" cellspacing="1" >
    <tr>
        <th>序号</th>
        <th>ID</th>
        <th>名字</th>
        <th>照片</th>
        <th>编辑</th>
        <th>删除</th>
    </tr>
    <tbody id="tBody">
    </tbody>
    <tr align="center"><td colspan="6"><button type="button" onclick="location.href='index.jsp'">添加</button></td></tr>
</table>
</body>
</html>