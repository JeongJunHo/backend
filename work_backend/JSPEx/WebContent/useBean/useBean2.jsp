<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.ssafy.Member" %>
<%-- <% Member mem = (Member)session.getAttribute("mem"); %> --%>
<jsp:useBean id="mem" class="edu.ssafy.Member" scope="session"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:setProperty property="name" name="mem" value="고길동"/>
	member.name = <jsp:getProperty property="name" name="mem"/> <br>
	member.age = <%= mem.getAge() %>
</body>
</html>