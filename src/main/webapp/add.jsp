<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	String path=request.getContextPath();
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="<%=path%>/css/index_work.css"/> 
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
</head>
<body>
	<form action="add" method="post" enctype="multipart/form-data">
	商品名称:<input type="text" name="gname"><br><br>
	商品品牌:<select name="did" id="one">
	<option>请选择</option>
	</select><br><br>
	商品种类:<select name="bid" id="two">
	<option>请选择</option>
	</select><br><br>
	商品状态:<select name="sum">
	<option>请选择</option>
	<option value="0">上架</option>
	<option value="1">下架</option>
	</select><br><br>
	商品单价:<input type="text" name="price"><br><br>
	商品介绍:<textarea rows="10" cols="15" name="jieshao"></textarea><br><br>
	商品图片:<input type="file" name="file"><br><br>
	<input type="submit" value="添加">
	</form>
</body>
<script type="text/javascript">
	$.post(
		"selectById",
		"",
		function(obj){
			for(var i in obj){
				$("#one").append("<option value="+obj[i].bid+">"+obj[i].bname+"</option>")
			}
		},
		"json"
	)
	$.post(
		"selectById1",
		"",
		function(obj){
			for(var i in obj){
				$("#two").append("<option value="+obj[i].did+">"+obj[i].dname+"</option>")
			}
		},
		"json"
	)
</script>
</html>