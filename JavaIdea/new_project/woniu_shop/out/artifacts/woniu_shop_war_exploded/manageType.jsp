<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品种类信息</title>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script>
        $(document).ready(function () {
            $.post("manageType.do",{"method":"showType"}, function (data, status) {
                showAll(data);
            });
        });
        function showAll(data) {
            var thead = $("#thead");
            var tbody = $("#tbody");
            var tfoot = $("#tfoot");
            thead.empty();
            tbody.empty();
            tfoot.empty();
            if( !(data instanceof Object) ){
                data = eval('('+data+')');
            }
            var pb = data.pageBean;
            thead.html("<tr align='center' bgcolor='#f0f8ff'>" +
                "<td>商品类型ID</td>" +
                "<td>类型名称</td>" +
                "<td height='15'><a href='javascript:void(0)' onclick='turnPage("+(pb.nowPage===1?1:pb.nowPage-1)+")'><font color=\"#6495ed\">前一页</font></a></td>" +
                "<td><a href='javascript:void(0)' onclick='turnPage("+(pb.nowPage===pb.totalPages?pb.nowPage:pb.nowPage+1)+")'><font color='#6495ed'>下一页</font></a></td>" +
                "</tr>");
            tfoot.html("<tr align='center' bgcolor='#f0f8ff'>" +
                "<td>商品类型ID</td>" +
                "<td>类型名称</td>" +
                "<td height='18'><a href='javascript:' onclick='turnPage(1)'><font color='#6495ed'>首页</font></a></td>" +
                "<td><a href='javascript:void(0)' onclick='turnPage("+pb.totalPages+")'><font color='#6495ed'>尾页(共"+pb.totalPages+"页)</font></a></td>" +
                "</tr>");

            $.each(data.list,function (index, pt) {
                var colorStr = index%2===0?"white":"#d1ebfe";
                var tr = $("<tr align='center' bgcolor='"+colorStr+"'></tr>");
                tr.html(
                    "<td height='18' >"+pt.typeID+"</td>" +
                    "<td>"+pt.typeName+"</td>" +
                    "<td><button type='button' onclick='edit("+(index+1)+","+pt.typeID+","+pb.nowPage+")'>编辑</button></td>"+
                    "<td><button type='button' onclick='del("+pt.typeID+","+pb.nowPage+")'>删除</button></td>"
                );
                tbody.append(tr);
            });
            
        }

        function del(typeID,nowPage) {
            $.post("manageType.do",{"method":"del","productID":typeID,"pageNum":nowPage},function (data, status) {
                showAll(data);
            });
        }
        function turnPage(pageNum){
            $.post("manageType.do",{"method":"showType","pageNum":pageNum},function (data, status) {
                showAll(data);
            })
        }

        function edit(trIndex,typeID,nowPage) {
            $(".editForm").remove();
            $.post("manageType.do",{"method":"edit","typeID":typeID,"pageNum":nowPage},function (data,status) {
                data = eval('('+data+')');
                $.each(data.list,function (index, pt) {
                    $("#tbody tr:nth-child("+trIndex+")").after($("<tr class='editForm' align='center' bgcolor='#f9b69b' onclick=''>" +
                        "<td class='tdEdit' height='15'><input type='hidden' name='typeID' value='"+pt.typeID+"'/> "+pt.typeID+"</td>" +
                        "<td class='tdEdit'><input type='text' name='typeName' value='"+pt.typeName+"' /></td>" +
                        "</tr>"
                    ));
                    var tdObj1 = $("<td class='tdEdit' ><button type='button'>提交</button></td>");
                    tdObj1.click(function () {
                        updateProduct(data.pageBean.nowPage);
                    });
                    var tdObj2 = "<td class='tdEdit'><button type='button' onclick='cancelEdit()'>取消</button></td>";
                    $("#tbody tr:nth-child("+trIndex+")").next().append(tdObj1);
                    $("#tbody tr:nth-child("+trIndex+")").next().append(tdObj2);
                });
                $("#tbody tr:nth-child("+(trIndex+1)+")").slideUp(1);
                $(".tdEdit").slideUp(1);
                $("#tbody tr:nth-child("+(trIndex+1)+")").slideDown(500);
                $(".tdEdit").slideDown(500);
            });
        }
        function updateProduct(nowPage) {
            $.post("manageType.do",{"method":"submit","typeID":$("[name=typeID]").val(),"typeName":$("[name=typeName]").val(),"pageNum":nowPage},function(data,status){
                showAll(data);
            });
            cancelEdit();
        }

        function cancelEdit() {
            $(".editForm").remove();
        }

    </script>

    <style>
        body{
            margin: 0;
            background-color: rgba(240,240,240,1);
            overflow: hidden;
        }
        a:link,a:visited{
            text-decoration: none;
        }
        a:hover,a:active{
            color: orange;
        }
        .table{
            margin: 0 auto;
            width: 60%;
            height: 1500px;
            background-color: white;
            box-shadow: 0 0 2px 1px rgba(0,0,0,0.3);
        }
        .tableContent{
            width: 100%;
            overflow: hidden;
            table-layout: fixed;
        }
        td{
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            padding: 10px 0;
            border-bottom: 1px gray solid;
        }
        input{
            width: 100px;
            text-align: center;
        }
        thead,tfoot{
            color: rgba(100,100,100,1);
        }
        thead td,tfoot td{
            border-right: 1px solid rgba(0,0,0,0.3);
        }
        thead td:last-child,tfoot td:last-child{
            border-right: none;
        }
    </style>
</head>
<body>
    <div class="table">
        <%--<form action="manageProduct.do?method=updateProduct" method="post" enctype="multipart/form-data">--%>
            <table class="tableContent" border="0" align="center" cellspacing="0">
                <thead id="thead"></thead>
                <tbody id="tbody"></tbody>
                <tfoot id="tfoot"></tfoot>
            </table>
        <%--</form>--%>
    </div>
</body>
</html>
