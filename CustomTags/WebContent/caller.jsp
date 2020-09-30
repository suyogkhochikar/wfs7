<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="demo" uri="http://amit.com" %>
<%@taglib prefix="newdemo" uri="http://xyz.com" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Today is <%=new java.util.Date() %></h2>
	<demo:mytag counter="10">
		<h4>Something inside</h4>
	</demo:mytag>
	<newdemo:newtag></newdemo:newtag>
</body>
</html>