<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品种类信息</title>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script>
        $(document).ready(function () {
            $.post("manageStock.do",{"method":"showStock"}, function (data, status) {
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
                "<td>进货ID</td>" +
                "<td>类型ID</td>" +
                "<td>数量</td>" +
                "<td>进货价</td>" +
                "<td>进货日期</td>" +
                "<td>供应商</td>" +
                "<td>进货人</td>" +
                "<td height='15'><a href='javascript:void(0)' onclick='turnPage("+(pb.nowPage===1?1:pb.nowPage-1)+")'><font color=\"#6495ed\">前一页</font></a></td>" +
                "<td><a href='javascript:void(0)' onclick='turnPage("+(pb.nowPage===pb.totalPages?pb.nowPage:pb.nowPage+1)+")'><font color='#6495ed'>下一页</font></a></td>" +
                "</tr>");
            tfoot.html("<tr align='center' bgcolor='#f0f8ff'>" +
                "<td>进货ID</td>" +
                "<td>类型ID</td>" +
                "<td>数量</td>" +
                "<td>进货价</td>" +
                "<td>进货日期</td>" +
                "<td>供应商</td>" +
                "<td>进货人</td>" +
                "<td height='18'><a href='javascript:' onclick='turnPage(1)'><font color='#6495ed'>首页</font></a></td>" +
                "<td><a href='javascript:void(0)' onclick='turnPage("+pb.totalPages+")'><font color='#6495ed'>尾页(共"+pb.totalPages+"页)</font></a></td>" +
                "</tr>");

            $.each(data.list,function (index, stock) {
                var colorStr = index%2===0?"white":"#d1ebfe";
                var tr = $("<tr align='center' bgcolor='"+colorStr+"'></tr>");
                tr.html(
                    "<td height='18' >"+stock.purchaseID+"</td>" +
                    "<td>"+stock.productID+"</td>" +
                    "<td>"+stock.quantity+"</td>" +
                    "<td>"+stock.primeCost+"</td>" +
                    "<td>"+stock.purchaseDate+"</td>" +
                    "<td>"+stock.supplier+"</td>" +
                    "<td>"+stock.buyer+"</td>" +
                    "<td><button type='button' onclick='edit("+(index+1)+","+stock.purchaseID+","+pb.nowPage+")'>编辑</button></td>"+
                    "<td><button type='button' onclick='del("+stock.purchaseID+","+pb.nowPage+")'>删除</button></td>"
                );
                tbody.append(tr);
            });
            
        }

        function del(purchaseID,nowPage) {
            $.post("manageStock.do",{"method":"del","purchaseID":purchaseID,"pageNum":nowPage},function (data, status) {
                showAll(data);
            });
        }
        function turnPage(pageNum){
            $.post("manageStock.do",{"method":"showStock","pageNum":pageNum},function (data, status) {
                showAll(data);
            })
        }

        function edit(trIndex,purchaseID,nowPage) {
            $(".editForm").remove();
            $.post("manageStock.do",{"method":"edit","purchaseID":purchaseID,"pageNum":nowPage},function (data,status) {
                data = eval('('+data+')');
                $.each(data.list,function (index, stock) {
                    $("#tbody tr:nth-child("+trIndex+")").after($("<tr class='editForm' align='center' bgcolor='#f9b69b' onclick=''>" +
                        "<td class='tdEdit' height='15'><input type='hidden' name='purchaseID' value='"+stock.purchaseID+"'/> "+stock.purchaseID+"</td>" +
                        "<td class='tdEdit'><input type='hidden' name='productID' value='"+stock.productID+"' />"+stock.productID+"</td>" +
                        "<td class='tdEdit'><input type='text' name='quantity' value='"+stock.quantity+"' /></td>" +
                        "<td class='tdEdit'><input type='text' name='primeCost' value='"+stock.primeCost+"' /></td>" +
                        "<td class='tdEdit'><input type='hidden' name='purchaseDate' value='"+stock.purchaseDate+"' />"+stock.purchaseDate+"</td>" +
                        "<td class='tdEdit'><input type='text' name='supplier' value='"+stock.supplier+"' /></td>" +
                        "<td class='tdEdit'><input type='text' name='buyer' value='"+stock.buyer+"' /></td>" +
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
            $.post("manageStock.do",{"method":"submit",
                "purchaseID":$("[name=purchaseID]").val(),
                "productID":$("[name=productID]").val(),
                "quantity":$("[name=quantity]").val(),
                "primeCost":$("[name=primeCost]").val(),
                "purchaseDate":$("[name=purchaseDate]").val(),
                "supplier":$("[name=supplier]").val(),
                "buyer":$("[name=buyer]").val(),
                "pageNum":nowPage},
                function(data,status){
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
            width: 70%;
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
        <%--<form id="myForm" action="manageProduct.do?method=updateProduct" method="post" enctype="multipart/form-data">--%>
            <table class="tableContent" border="0" align="center" cellspacing="0">
                <thead id="thead"></thead>
                <tbody id="tbody"></tbody>
                <tfoot id="tfoot"></tfoot>
            </table>
        <%--</form>--%>
    </div>
</body>
</html>
