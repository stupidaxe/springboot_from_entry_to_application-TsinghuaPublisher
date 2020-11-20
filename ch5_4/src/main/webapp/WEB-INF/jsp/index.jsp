<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 引入JSTL标签 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>  
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>JSP测试</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">第一个基于JSP技术的Spring Boot Web应用</h3>
		</div>
	</div>
	<div class="container">
		<div>
        	<h4>图书列表</h4>
    	</div>
		<div class="row">
			<div class="col-md-4 col-sm-6">
				<!-- 使用EL表达式 -->
				<a href="">
					<img src="images/${aBook.picture}" alt="图书封面" style="height: 180px; width: 40%;"/>
				</a>
				<div class="caption">
					<h4>${aBook.bname}</h4>
					<p>${aBook.author}</p>
					<p>${aBook.isbn}</p>
					<p>${aBook.price}</p>
					<p>${aBook.publishing}</p>
				</div>
			</div>
			<!-- 使用JSTL标签forEach循环取出集合数据 -->
			<c:forEach var="book" items="${books}">
				<div class="col-md-4 col-sm-6">
				<a href="">
					<img src="images/${book.picture}" alt="图书封面" style="height: 180px; width: 40%;"/>
				</a>
				<div class="caption">
					<h4>${book.bname}</h4>
					<p>${book.author}</p>
					<p>${book.isbn}</p>
					<p>${book.price}</p>
					<p>${book.publishing}</p>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>