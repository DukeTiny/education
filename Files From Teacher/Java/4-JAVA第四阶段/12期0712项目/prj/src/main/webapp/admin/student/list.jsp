<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/locale/easyui-lang-zh_CN.js"></script>
<script>
	$(function(){
		$('#dg').datagrid({   
		    url:'findAll',   
		    fitColumns:true,
		    pagination:true,
		    toolbar: '#tb',
		    title:'美丽的学生管理系统',
		    columns:[[   
		        {field:'stid',title:'stid',checkbox:true,width:100},   
		        {field:'stname',title:'stname',width:100},   
		        {field:'age',title:'age',width:100,align:'right'},   
		        {field:'score',title:'score',width:100,align:'right',styler: function(value,row,index){
					if (value < 60){
						return 'color:red;';
					}
				}},
				{field:'xxx',title:'operate',width:100,align:'center',formatter: function(value,row,index){
					var btns = "<a id=\"btn\" href=\"javascript:dodelete("+row.stid+")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-remove'\">删除</a>";
					btns += "<a id=\"btn\" href=\"javascript:openForm("+row.stid+")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-edit'\">修改</a>";
					return btns
				}
			}
		    ]],
		    onLoadSuccess: function(index,field,value){
				$('.easyui-linkbutton').linkbutton({   
				});  
			}   
		});  

	})
	
	function dodelete(stid){
		$.messager.confirm('Confirm','Are you sure you want to delete record?',function(r){   
		    if (r){   
		    	$.getJSON("delete",{stid:stid},function(json){
					$('#dg').datagrid('reload');    // reload the current page data
					$.messager.show({
						title:'My Title',
						msg:json.msg,
						timeout:5000,
						showType:'slide'
					});
				});
		    }   
		});  
		
	}
	
	function deleteBatch(){
		var chks = $('#dg').datagrid('getSelections');  // fix the 'name' column size
		let ids = "";
		if(chks.length<1){
			$.messager.alert('Warning','你是否应该至少选择一个呀'); 
		}else{
			for(let i=0;i<chks.length;i++){
				ids += chks[i].stid;
				if(i<chks.length-1){
					ids += ",";
				}
			}
			$.getJSON("deleteBatch",{ids:ids},function(json){
				$('#dg').datagrid('reload');    // reload the current page data
				$.messager.show({
					title:'My Title',
					msg:json.msg,
					timeout:5000,
					showType:'slide'
				});
			});
		}
	}
	
	function openForm(stid){
		$('#win').window('open');  // open a window   
		$('#ff').form('clear');	// 从URL加载 
		if(stid!=undefined){
			$('#ff').form('load','findById?stid='+stid);	// 从URL加载 
		}
	}
	
	function doSubmit(){
		// call 'submit' method of form plugin to submit the form  
		var stid = $("#stid").val();
		var path = "save";
		if(stid!=null&&stid!=""){
			path = "update";
		}
		
		
		
		$('#ff').form('submit', {   
		    url:path,   
		    onSubmit: function(){   
		        // do some check   
		        // return false to prevent submit;   
		    },   
		    success:function(data){   
		        var json = eval("("+data+")");
		        $('#dg').datagrid('reload');    // reload the current page data
				$.messager.show({
					title:'My Title',
					msg:json.msg,
					timeout:5000,
					showType:'slide'
				});
				$('#win').window('close');  // close a window 
		    }   
		}); 

	}
</script>

</head>
<body>
<table id="dg"></table>


<div id="tb">
<a href="javascript:openForm()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">增加</a>
<a href="javascript:deleteBatch()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
</div>

<div id="win" class="easyui-window" title="My Window" style="width:600px;height:400px"  
        data-options="iconCls:'icon-save',modal:true,closed:true">  
    <form id="ff" method="post">  
    <input type="text" id="stid" name="stid">
    <div>  
        <label for="name">stname:</label>  
        <input class="easyui-validatebox" type="text" name="stname" data-options="required:true" />  
    </div> 
    <div>  
        <label for="name">age:</label>  
        <input class="easyui-validatebox" type="text" name="age" data-options="required:true" />  
    </div>
    <div>  
        <label for="name">score:</label>  
        <input class="easyui-validatebox" type="text" name="score" data-options="required:true" />  
    </div> 
    <div>  
        <a id="btn" href="javascript:doSubmit()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">保存</a>  
        
    </div> 
</form>  
   
</div>  


</body>
</html>