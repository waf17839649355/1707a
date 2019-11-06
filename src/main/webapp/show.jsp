<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
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
	<form:form action="/update" method="post" modelAttribute="goods">
	商品名称:<form:input path="gname" readonly="readonly"/><br><br>
	商品品牌:<form:select path="did" id="one" disabled="disabled">
	<c:forEach items="${list}" var="l">
	<form:option value="${l.bid}">${l.bname}</form:option>
	</c:forEach>
	</form:select><br><br>
	商品种类:<form:select path="bid" id="two" disabled="disabled">
	<c:forEach items="${list2}" var="l">
	<form:option value="${l.did}">${l.dname}</form:option>
	</c:forEach>
	</form:select><br><br>
	商品单价:<form:input path="price" readonly="readonly"/><br><br>
	商品介绍:<form:textarea rows="10" cols="15" path="jieshao" readonly="readonly"/><br><br>
	商品图片:<input type="image" width="100" height="50" src="/lookImg?path=${goods.imgurl}"><br><br>
	<a href="list"><input type="button" value="返回查询列表"></a>
	</form:form>
</body>
</html>