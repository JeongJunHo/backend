<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String userType = request.getParameter("userType"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:parseDate var="d" value="20190920" pattern="yyyymmdd"/>
	<fmt:formatDate value="${d}" pattern="yyyy-mm-dd"/><br>
	<fmt:formatNumber>1000</fmt:formatNumber><br>

	<c:if test="${param.userType eq 'member'}">
		<jsp:include page="../forward1.jsp"></jsp:include>
		<h2>나는 맴버 입니다.</h2>
	</c:if>
	<c:if test="${param.userType eq 'guest'}">
		<jsp:include page="../include.jsp"></jsp:include>
		<h2>나는 게스트 입니다.</h2>
	</c:if>
	<c:choose>
		<c:when test="${not empty param.userType}">
		
		</c:when>
		<c:otherwise>
			ddddddddddddddddddddd
		</c:otherwise>
	</c:choose>
	
	<c:set var="price" value="5000,6000,7000"/>
	<c:out value="${total}" default="00000"/>
	${price}<br>
	<c:forEach items="${price}" var="p">
		<c:set var="total" value="${p+total}"/>
		price : ${p}<br>
		total : ${total}<br>
		<br>
	</c:forEach>
	
	${total}<br>
	토탈 변경 : ${total=2222}<br>
	<c:choose>
		<c:when test="">
		
		</c:when>
		<c:when test="">
		
		</c:when>
		<c:otherwise>
		
		</c:otherwise>
	</c:choose>
	
	<c:out value="${total}" default="00000"/>
</body>
</html>