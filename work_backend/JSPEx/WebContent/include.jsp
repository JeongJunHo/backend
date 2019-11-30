<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	include.jsp 에서 출력 <%= "Hello" %>
	<jsp:include page="sub.jsp" flush="true"/>
	include 완료
</body>
</html>