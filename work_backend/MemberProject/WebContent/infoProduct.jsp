<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>회원 수정</title>

<script type="text/javascript">
	function deleteProduct(){
		location.href = "product.do?action=deleteProduct&code=${product.code}";
	}
</script>
</head>
<body>
	<div id="outer">
		<%@ include file="menu.jsp" %>
		
		<h1 align="center">제품 정보</h1>
		<p align="right">마지막 수정자 : ${not empty product.up_mb_id ? product.up_mb_id : product.reg_mb_id}</p>
		<p align="right">마지막 수정시간 : <fmt:formatDate value="${empty product.up_date ? product.reg_date : product.up_date}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
		<form action="product.do?action=updateProduct" method="POST" id="rform">
			<table border="1" class="mb-15">
				<tr>
					<th>CODE</th>
					<td>
						<input type="text" name="code" value="${product.code}" readonly="readonly" style="background: #dcdcdc;" required="required">
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" name="name" value="${product.name}" required="required">
					</td>
				</tr>
				<tr>
					<th>가격</th>
					<td>
						<input type="number" name="price" value="${product.price}" required="required">
					</td>
				</tr>
				<tr>
					<th>가격</th>
					<td>
						<input type="number" name="stock" value="${product.stock}" required="required">
					</td>
				</tr>
				<tr>
					<th>메모</th>
					<td>
						<textarea rows="5" cols="22" name="memo">${product.memo}</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정">
						<input type="button" value="삭제" onclick="deleteProduct()">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>