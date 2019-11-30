<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	request.setAttribute("msg", "Hello");
// 	pageContext.forward("forward2.jsp");
%>
	<h1>Forward 1 page</h1>
<%-- 	<jsp:forward page="forward2.jsp"/> --%>

</body>
</html>