<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>제품 등록</title>

</head>
<body>
	<div id="outer">
		<%@ include file="menu.jsp" %>
		
		<h1 align="center">제품 등록</h1>
		
		<form action="product.do" method="POST" id="rform">
			<input type="hidden" name="action" value="registerProduct">
			<table border="1" class="mb-15">
				<tr>
					<th>CODE</th>
					<td>
						<input type="text" name="code" required="required">
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" name="name" required="required">
					</td>
				</tr>
				<tr>
					<th>가격</th>
					<td>
						<input type="number" name="price" required="required">
					</td>
				</tr>
				<tr>
					<th>수량</th>
					<td>
						<input type="number" name="stock" required="required">
					</td>
				</tr>
				<tr>
					<th>메모</th>
					<td>
						<textarea rows="5" cols="22" name="memo"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="등록">
						<input type="reset" value="reset">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>