<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="mem" class="edu.ssafy.Member"></jsp:useBean>
<jsp:setProperty property="name" name="mem" value="둘리"/>
<jsp:setProperty property="age" name="mem" value="21"/>

<%
// 	pageContext.setAttribute("id", "ssafy");
	pageContext.removeAttribute("id");
	String[] subject = {"java", "c++", "python"};
	pageContext.setAttribute("subject", subject);
	
	session.setAttribute("id", "ssafy2");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	EL 이용하여 Member의 이름과 나이를 출력합니다.<br>
	이름 : ${mem.name} 나이 : ${mem.age}
	${pageScope.id}, ${pageScope.subject[0]}, ${pageScope.subject[1]}, ${pageScope.subject[2]}
	${id eq 'ssafy' ? 'aa' : 'ccc'}<br>
	${sessionScope.id}<br>
	${empty param.userType}
</body>
</html>