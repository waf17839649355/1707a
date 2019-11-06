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
	<div>
	<form action="list" method="post">
	<input type="text" name="lname">
	<input type="submit" value="搜索">
	<a href="toadd"><input type="button" value="添加"></a>
	<input type="button" value="批量删除" onclick="dels()">
	</form>
	</div>
	<div>
	<form action="list" method="post">
	排序字段:<select name="come">
	<option value="gid">序号</option>
	<option value="gname">名称</option>
	<option value="price">价格</option>
	</select>
	排序方式:<select name="sc">
	<option value="asc">升序</option>
	<option value="desc">降序</option>
	</select>
	<input type="submit" value="排序">
	</form>
	</div>
	<table>
	<tr>
	<td>
	<input type="checkbox" id="qx">全选/全不选
	</td>
	<td>编号</td>
	<td>商品名称</td>
	<td>商品品牌</td>
	<td>商品价格</td>
	<td>商品分类</td>
	<td>商品状态</td>
	<td>商品介绍</td>
	<td>商品图片</td>
	<td colspan="3">操作</td>
	</tr>
	<c:forEach items="${list}" var="l">
	<tr>
	<td><input type="checkbox" class="ids" value="${l.gid}"></td>
	<td>${l.gid}</td>
	<td>${l.gname}</td>
	<td>${l.bname}</td>
	<td>${l.price}</td>
	<td>${l.dname}</td>
	<td>
	<c:if test="${l.sum == 1}">
	<a href="updateGoods?sum=${l.sum}&gid=${l.gid}">下架</a>
	</c:if>
	<c:if test="${l.sum == 0}">
	<a href="updateGoods?sum=${l.sum}&gid=${l.gid}">上架</a>
	</c:if>
	</td>
	<td>${l.jieshao}</td>
	<td><input type="image" width="100" height="50" src="/lookImg?path=${l.imgurl}"> </td>
	<td>
	<a href="toupdate?gid=${l.gid}&sum=1"><input type="button" value="修改"></a>
	</td>
	<td>
	<input type="button" value="删除" onclick="del(${l.gid})">
	</td>
	<td>
	<a href="toupdate?gid=${l.gid}&sum=0"><input type="button" value="查看详情"></a>
	</td>
	</tr>
	</c:forEach>
	<tfoot>
	<tr>
	<td colspan="11">
	<a href="?pageNum=1">首页</a>
	<a href="?pageNum=${page.pageNum-1<1?page.pageNum:page.pageNum-1}">上一页</a>
	<a href="?pageNum=${page.pageNum+1>page.pages?page.pageNum:page.pageNum+1}">下一页</a>
	<a href="?pageNum=${page.pages}">尾页</a>
	</td>
	</tr>
	</tfoot>
	</table>
</body>
<script type="text/javascript">
	function dels(){
		var len=$(".ids:checked").length
		if(len>0){
			if(confirm("确认删除吗")){
				var gid ="";
				$(".ids:checked").each(function(){
					gid+=","+$(this).val()
				})
				gid=gid.substring(1)
				$.post(
					"deleteGoods",
					{gid:gid},
					function(obj){
						if(obj>0){
							alert("你成功删除了"+len+"条数据！！")
							location="/list"
						}else{
							alert("删除失败！！")
						}
					},
					"json"
				)
			}
		}else{
			alert("请至少选择一条数据！！")
		}
	}
	function del(gid){
		if(confirm("确认删除吗")){
			$.post(
				"deleteGoods",
				{gid:gid},
				function(obj){
					if(obj>0){
						alert("删除成功！！")
						location="/list"
					}else{
						alert("删除失败！！")
					}
				},
				"json"
			)
		}
	}
</script>
</html>