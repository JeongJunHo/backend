<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.ssafy.Member" %>
<% 
	Member mem = new Member("둘리", "21");
	session.setAttribute("mem", mem);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="useBean2.jsp">useBean2</a>
</body>
</html>