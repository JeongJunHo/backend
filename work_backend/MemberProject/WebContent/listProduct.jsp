<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".pname").hover(function(){
			var code = $(this).data("code");
			$.ajax({
				url: "product.do",
				type: "POST",
				data: {
					code : code,
					action : "selectOne_json"
					},
				success: function(ret){
					$("#detail").text(ret.code + "," + ret.name + "," + ret.price + "," + ret.stock + "," + ret.memo + "," + ret.reg_mb_id + "," + ret.reg_date + "," + ret.up_mb_id + "," + ret.up_date);
				},
				dataType:"json"
			});
		});
	});
</script>
</head>
<body>
	<div id="outer">
		<%@ include file="menu.jsp" %>
		
		<h1>제품 리스트</h1>
		<div class="mb-15" align="right">
			<form action="product.do" method="POST">
				<input type="hidden" name="action" value="listProduct">
				<label for="searchName">제품명</label>
				<input type="text" id="searchName" name="searchName" value="${param.searchName}">
				<label for="searchPrice">가격</label>
				<input type="number" id="searchPrice" name="searchPrice" value="${param.searchPrice}">
				<button type="submit">검색</button>
			</form>
		</div>
		<table border="1" class="mb-15">
			<tr>
				<th>CODE</th>
				<th>제품명</th>
				<th>가격</th>
				<th>수량</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			
			<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.code}</td>
				<td class="pname" data-code="${item.code}">
					<a href="product.do?action=infoProduct&code=${item.code}">${item.name}</a>
				</td>
				<td>${item.price}</td>
				<td>${item.stock}</td>
				<td>${empty item.up_mb_id ? item.reg_mb_id : item.up_mb_id}</td>
				<td>
					<fmt:formatDate value="${empty item.up_date ? item.reg_date : item.up_date}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
			</tr>
			</c:forEach>
			
			<c:if test="${list.size() eq 0}">
				<tr>
					<td colspan="6">등록된 제품이 없습니다.</td>
				</tr>
			</c:if>
		</table>
		
		<div id="detail"></div>
	</div>
</body>
</html>