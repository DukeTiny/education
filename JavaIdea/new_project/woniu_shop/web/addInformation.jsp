<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/19
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加信息</title>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script>
        function addPT() {
            removeTable();
            $("#tbody").html($("<tr align='center'><td>" +
                "<button type='button' onclick='tableAdd()'>表格添加</button></td></tr>" +
                "<tr><td><button type='button' onclick='signalAdd()'>逐条添加</button>" +
                "</td></tr>"));
            $("button").css("width","800px");
            $("#myForm").attr("action","manageStock.do?method=add");
        }

        function tableAdd() {
            removeTable();
            $("#tbody").html($("<tr><td>" +
                "<input type='file' name='file' size='5'  style='border:none;'></td></tr>" +
                "</td></tr>"));
            $("#tfoot").html($("<tr><td>" +
                "<button>提交</button>&nbsp;&nbsp;&nbsp;" +
                "<button onclick='cancelAdd()' type='button'>取消</button>" +
                "</td></tr>"));
            $("button").css("width","450px");
            $("#myForm").attr("action","manageType.do?method=addWithFile");
            $("#myForm").attr("enctype","multipart/form-data");
        }

        function signalAdd() {
            removeTable();
            $("#thead").html($("<tr align='center' bgcolor='#f0f8ff'>" +
                "<td>商品类型ID</td>" +
                "<td>类型名称</td>" +
                "</tr>)"));
            $("#tfoot").html($("<tr><td colspan='2'>" +
                "<button>提交</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                "<button onclick='cancelAdd()' type='button'>取消</button>" +
                "</td></tr>"));
            $("#tbody").html($("<tr><td>" +
                "<input class='addPT' type='text'name='typeID'></td> " +
                "<td><input class='addPT' type='text'name='typeName'> " +
                "</td></tr>"));
            $(".addPT").css({"width":"200px","height":"20px"});
            $("button").css("width","400px");
            $("#myForm").attr("action","manageType.do?method=add");
            $("td").css("border-bottom","1px gray solid");
        }

        function addProduct() {
            removeTable();
            $("#thead").html("<tr align='center' bgcolor='#f0f8ff'>" +
                "<td height='10'>商品ID</td>" +
                "<td>名称</td>" +
                "<td>品牌</td>" +
                "<td>类型id</td>" +
                "<td>售价</td>" +
                "<td>单位</td>" +
                "<td>商品图片</td>" +
                "<td>是否下架</td>" +
                "<td width='100'>优先级</td>" +
                "</tr>");
            $("#tbody").html($("<tr class='editForm' align='center' bgcolor='#d3d3d3' onclick=''>" +
                "<td class='tdEdit' height='15'><input type='hidden' name='productId'>自动生成</td>" +
                "<td class='tdEdit'><input type='text' name='productName'></td>" +
                "<td class='tdEdit'><input type='text' name='productBrand'></td>" +
                "<td class='tdEdit'><input type='text' name='typeID'></td>" +
                "<td class='tdEdit'><input type='text' name='unitPrice' /></td>" +
                "<td class='tdEdit'><input type='text' name='unit' /></td>" +
                "<td class='tdEdit'><input type='file' id='productPhoto'></td>" +
                "<td class='tdEdit'><select name='onSale'>" +
                "<option value='0'>上架</option>" +
                "<option value='1'>下架</option>" +
                "</select></td>" +
                "<td class='tdEdit'><select  name='priority'><option value='hot'>hot</option><option value='normal'>normal</option></select></td>" +
                "</tr>"));
            $("#tfoot").html($("<tr><td colspan='9'>" +
                "<button>提交</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                "<button onclick='cancelAdd()' type='button'>取消</button>" +
                "</td></tr>"));
            $("button").css("width","400px");
            $("#myForm").attr("action","manageProduct.do?method=add");
            $("#myForm").attr("enctype","multipart/form-data");
            $("td").css("border-bottom","1px gray solid");
        }

        function addStock() {
            removeTable();
            $("#thead").html($("<tr align='center' bgcolor='#f0f8ff'>" +
                "<td>进货ID</td>" +
                "<td>类型ID</td>" +
                "<td>数量</td>" +
                "<td>进货价</td>" +
                "<td>进货日期</td>" +
                "<td>供应商</td>" +
                "<td>进货人</td>" +
                "</tr>"));
            $("tbody").html($("<tr><td height='18' >自动生成</td>" +
                "<td><input type='text' name='productID'/></td>" +
                "<td><input type='text' name='quantity'/></td>" +
                "<td><input type='text' name='primeCost'/></td>" +
                "<td><input type='date' name='purchaseDate' style='width:120px;'/></td>" +
                "<td><input type='text' name='supplier'/></td>" +
                "<td><input type='text' name='buyer'/></td>" +
                "</tr>"));
            $("#tfoot").html($("<tr><td colspan='7'>" +
                "<button type='button'>提交</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                "<button onclick='cancelAdd()' type='button'>取消</button>" +
                "</td></tr>"));
            $("button").css("width","400px");
            $("#myForm").attr("action","manageStock.do?method=add");
            $("td").css("border-bottom","1px gray solid");
        }


        function removeTable() {
            $("#thead").empty();
            $("#tbody").empty();
            $("#tfoot").empty();
        }

        function cancelAdd() {
            $("#thead").html($("<tr><td>\n" +
                "<button type=\"button\" onclick=\"addPT()\">添加商品种类</button>\n" +
                "</td></tr>"));
            $("#tbody").html($(" <tr><td>\n" +
                "<button type=\"button\" onclick=\"addProduct()\">添加商品</button>\n" +
                "</td></tr>"));
            $("#tfoot").html($(" <tr><td>\n" +
                "<button type=\"button\" onclick=\"addStock()\">添加进货信息</button>\n" +
                "</td></tr>"));
        }

    </script>

    <style>
        body{
            margin: 0;
        }
        .table{
            margin: auto;
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
        }
        input{
            width: 100px;
            height: 20px;
            text-align: center;
        }
        #thead,#tbody,tfoot{
            margin: auto;
            text-align: center;
        }
        button{
            width: 500px;
            height: 50px;
            color: white;
            border-radius: 10px;
            background: darkorange;
            border: none;
            font-size: 18px;
            font-family: "思源黑体 CN", "微软雅黑";
        }


    </style>
</head>
<body>
<div class="nav">
</div>
<div class="table">
    <form id="myForm" action="manageProduct.do?method=add" method="post">
        <table class="tableContent" border="0" align="center" cellspacing="0" cellpadding="10">
            <thead id="thead">
            <tr><td>
                <button type="button" onclick="addPT()">添加商品种类</button>
            </td></tr>
            </thead>
            <tbody id="tbody">
            <tr><td>
                <button type="button" onclick="addProduct()">添加商品</button>
            </td></tr>
            </tbody>
            <tfoot id="tfoot">
            <tr><td>
                <button type="button" onclick="addStock()">添加进货信息</button>
            </td></tr>
            </tfoot>
        </table>
    </form>
</div>
</body>
</html>
