<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/14
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>This is list</title>
</head>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script>

        $(document).ready(function () {
            var list = $("#list");
            $.get("login.do", {"method": "list2"}, function (data, status) {
                showALlUsers(data)
            });

            function showALlUsers(data) {
                list.empty();
                var datas = eval('(' + data + ")");
                $.each(datas, function (index, user) {
                    var trObj = $("<tr align='center'></tr>");
                    trObj.append($("<td>" + (index + 1) + "</td>"));
                    trObj.append($("<td>" + (user.uid) + "</td>"));
                    trObj.append($("<td>" + (user.uName) + "</td>"));
                    trObj.append($("<td>" + (user.uPwd) + "</td>"));
                    trObj.append($("<td>" + (user.uRole) + "</td>"));
                    trObj.append($("<td>" + (user.uStatus) + "</td>"));
                    var btn = $("<td><button class='btn' >编辑</button></td>");
                    btn.click(function() {
                        $("#editButton").text("提交");
                        $("#editForm").css("visibility","visible");
                        $.get("login.do",{"method":"getOne","uid":user.uid},function (data,status) {
                            var u = eval('('+data+')');
                            $("#uid").val(u.uid);
                            $("#uname").val(u.uName);
                            $("#upwd").val(u.uPwd);
                            $("#urole").val(u.uRole);
                            $("#ustatus").val(u.uStatus);
                        });
                    });
                    trObj.append(btn);
                    var delBtn = $("<td><button>删除</button></td>");
                    delBtn.click(function () {
                        $.get("login.do",{"method":"delUser","uid":user.uid},function (data,status) {
                            var u = eval('('+data+')');
                            showALlUsers(data)
                        });
                    });
                    trObj.append(delBtn);
                    list.append(trObj);
                });
            }


            $("#editButton").click(function () {
                var buttonText = $("#editButton");
                if( buttonText.text()==="提交"){
                    $.get("login.do",
                    {"method":"updateUser","uid":$("#uid").val(),"uname":$("#uname").val(),"upwd":$("#upwd").val(),"urole":$("#urole").val(),"ustatus":$("#ustatus").val()},
                    function (data, status) {
                        showALlUsers(data);
                    });
                }
                else if( buttonText.text()==="新增"){
                    $.get("login.do",
                        {"method":"addNewUser","uname":$("#uname").val(),"upwd":$("#upwd").val(),"urole":$("#urole").val(),"ustatus":$("#ustatus").val()},
                        function (data, status) {
                            showALlUsers(data);
                    });
                }
            });
            $("#changeContext").click(function () {
                $("#editButton").text("新增");
                $("#editForm").css("visibility","visible");
                $("#uid").val("");
                $("#uname").val("");
                $("#upwd").val("");
            });

        });

    </script>
<body>
    <table width="800" align="center" border="1"cellpadding="5">
        <caption>THIS IS LIST</caption>
        <thead>
            <tr>
                <th>序号</th>
                <th>用户ID</th>
                <th>用户名</th>
                <th>用户密码</th>
                <th>用户角色</th>
                <th>用户状态</th>
                <th>修改</th>
                <th>删除</th>
            </tr>
        </thead>
        <tbody id="list"></tbody>
        <tr align="center">
            <td colspan="8"><button type="button" id="changeContext">Add New User</button></td>
        </tr>
    </table>
    <br /><br />
    <div id="editForm" style="margin:0 auto; border: 1px solid gray; padding: 15px; width: 220px; visibility: hidden;" >
        <input type="hidden" name="uid" id="uid">
        用&nbsp;户&nbsp;名：&nbsp;<input type="text" name="uname" id="uname"><br />
        用户密码：<input type="text" name="uname" id="upwd"><br />
        用户角色：<select name="urole" id="urole">
                    <option value="普通用户">普通用户</option>
                    <option value="管理员">管理员</option>
                </select>
                <br />
        用户状态：<select name="ustatus" id="ustatus">
                      <option>Normal</option>
                      <option>Freezied</option>
                </select>
                <br />
        <button type="button" id="editButton" >提交</button>
    </div>
</body>
</html>
