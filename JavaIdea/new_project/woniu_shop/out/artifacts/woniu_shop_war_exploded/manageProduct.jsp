<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品信息</title>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script>
        $(document).ready(function () {
            $.post("manageProduct.do", {"method": "showProduct"}, function (data, status) {
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
                "<td>商品ID</td>" +
                "<td>名称</td>" +
                "<td>品牌</td>" +
                "<td>类型id</td>" +
                "<td>售价</td>" +
                "<td>单位</td>" +
                "<td>商品图片</td>" +
                "<td>是否下架</td>" +
                "<td width='100'>优先级</td>" +
                "<td height='15'><a href='javascript:void(0)' onclick='turnPage("+(pb.nowPage===1?1:pb.nowPage-1)+")'><font color=\"#6495ed\">前一页</font></a></td>" +
                "<td><a href='javascript:void(0)' onclick='turnPage("+(pb.nowPage===pb.totalPages?pb.nowPage:pb.nowPage+1)+")'><font color='#6495ed'>下一页</font></a></td>" +
                "</tr>");
            tfoot.html("<tr align='center' bgcolor='#f0f8ff'>" +
                "<td>商品ID</td>" +
                "<td>名称</td>" +
                "<td>品牌</td>" +
                "<td>类型id</td>" +
                "<td>售价</td>" +
                "<td>单位</td>" +
                "<td>商品图片</td>" +
                "<td>是否下架</td>" +
                "<td width='100'>优先级</td>" +
                "<td height='18'><a href='javascript:' onclick='turnPage(1)'><font color='#6495ed'>首页</font></a></td>" +
                "<td><a href='javascript:void(0)' onclick='turnPage("+pb.totalPages+")'><font color='#6495ed'>尾页(共"+pb.totalPages+"页)</font></a></td>" +
                "</tr>");
            
            $.each(data.list,function (index, product) {
                var colorStr = index%2===0?"white":"#d1ebfe";
                var tr = $("<tr align='center' bgcolor='"+colorStr+"'></tr>");
                tr.html(
                    "<td height='18' >"+product.productID+"</td>" +
                    "<td>"+product.productName+"</td>" +
                    "<td>"+product.productBrand+"</td>" +
                    "<td>"+product.typeID+"</td>" +
                    "<td>"+product.unitPrice+"</td>" +
                    "<td>"+product.unit+"</td>" +
                    "<td><img height='30' src='<%=request.getContextPath()%>"+product.productPhoto+"'/></td>" +
                    "<td>"+(product.onSale===1?"是":"否")+"</td>" +
                    "<td>"+product.priority+"</td>"+
                    "<td><button type='button' onclick='edit("+(index+1)+","+product.productID+")'>编辑</button></td>"+
                    "<td><button type='button' onclick='del("+product.productID+","+pb.nowPage+")'>删除</button></td>"
                );
                tbody.append(tr);
            });
            
        }

        function del(productID,nowPage) {
            $.post("manageProduct.do",{"method":"del","productID":productID,"pageNum":nowPage},function (data, status) {
                showAll(data);
            });
        }

        function turnPage(pageNum){
            $.post("manageProduct.do",{"method":"showProduct","pageNum":pageNum},function (data, status) {
                showAll(data);
            })
        }

        function edit(trIndex,prodID) {
            $(".editForm").remove();
            $.post("manageProduct.do",{"method":"edit","prodID":prodID},function (data,status) {
                data = eval('('+data+')');
                $.each(data,function (index, product) {
                    $("#tbody tr:nth-child("+trIndex+")").after($("<tr class='editForm' align='center' bgcolor='#f9b69b' onclick=''>" +
                        "<td class='tdEdit' height='15'>"+product.productID+"<input type='hidden' value='"+product.productID+"' name='productID'></td>" +
                        "<td class='tdEdit'><input type='text' name='productName' value='"+product.productName+"'></td>" +
                        "<td class='tdEdit'><input type='text' name='productBrand' value='"+product.productBrand+"'></td>" +
                        "<td class='tdEdit'><input type='text' name='typeID' value='"+product.typeID+"'></td>" +
                        "<td class='tdEdit'><input type='text' name='unitPrice' value='"+product.unitPrice+"'></td>" +
                        "<td class='tdEdit'><input name='unit' value='"+product.unit+"'/></td>" +
                        "<td class='tdEdit'><input type='file' id='productPhoto'></td>" +
                        "<td class='tdEdit'><select name='onSale' value='"+(product.onSale===1?"下架":"上架")+"'>" +
                        "<option>上架</option>" +
                        "<option>下架</option>" +
                        "</select></td>" +
                        "<td class='tdEdit'><select value='"+product.priority+"' name='priority'><option>hot</option><option>normal</option></select></td>" +
                        "</tr>"
                    ));
                    var tdObj1 = $("<td class='tdEdit' ><button type='button'>提交</button></td>");
                    tdObj1.click(function () {
                        updateProduct();
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
        function updateProduct() {
            var formData = new FormData();
            formData.append("productID",$("[name=productID]").val());
            formData.append("productName",$("[name=productName]").val());
            formData.append("productBrand",$("[name=productBrand]").val());
            formData.append("typeID",$("[name=typeID]").val());
            formData.append("unitPrice",$("[name=unitPrice]").val());
            formData.append("unit",$("[name=unit]").val());
            formData.append("productPhoto",$("#productPhoto")[0].files[0]);
            formData.append("onSale",$("[name=onSale]").val());
            formData.append("priority",$("[name=priority]").val());
            $.ajax({
                url: "manageProduct.do",
                type: "POST",
                cache: false,
                data: formData,
                async: true,
                processData: false,
                contentType: false,
                dataType: "JSON",
                success: function (data,textStatus) {
                    showAll(data);
                },
                error:function () {
                    alert("Error");
                }
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
            width: 80%;
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
