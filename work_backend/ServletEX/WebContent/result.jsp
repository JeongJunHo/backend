<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, java.awt.*, edu.entity.Book"
    errorPage="error.jsp"
    %>
   
<%-- <%! int a, b, sum; %> --%>
<% 
// 	a = 10;
// 	b = 20;
// 	sum = a + b;
	Book b;
	String res = (String) request.getAttribute("res");
	int sum = 5/0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 	<h1> a + b = <%= sum %> </h1> --%>
	<h1><%= res %></h1>
</body>
</html>