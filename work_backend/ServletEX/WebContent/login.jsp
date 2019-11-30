<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="error.jsp"
    %>
    
<%! String res; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	//한글처리
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=utf-8");
	//파라미터 처리
	String name = request.getParameter("userid");
	String passwd = request.getParameter("passwd");
	//로직처리
	if(name.equals("ssafy")&&passwd.equals("ssafy")) {
		res = "접속하신 " + name + "는 로그인 되었습니다.jsp";
		request.setAttribute("res", res);
	}else {
		res = "접속하신 " + name + "는 로그인 되지 않았습니다.jsp";
		request.setAttribute("res", res);
	}
			
	int sum = 5/0;
	%>
	<h1><%= res %></h1>
</body>
</html>