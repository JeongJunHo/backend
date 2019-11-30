<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
	<div id="outer">
		<%@ include file="menu.jsp" %>
		
		<h1>회원 리스트</h1>
		<table border="1" class="mb-15">
			<tr>
				<th>ID</th>
				<th>이름</th>
				<th>성별</th>
			</tr>
			
			<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.id}</td>
				<td><a href="main.do?action=infomem&pid=${item.id}">${item.name}</a></td>
				<td>${item.gender}</td>
			</tr>
			</c:forEach>
			
			<c:if test="${list.size() eq 0}">
				<tr>
					<td colspan="6">등록된 회원이 없습니다.</td>
				</tr>
			</c:if>
		</table>
	</div>
</body>
</html>