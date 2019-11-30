<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="common.jsp"/>

<script>
	$(document).ready(function() {		
		$(".delete_btn").click(function(){
			if(confirm("정말 삭제하시겠습니까?")){
				var num = $(this).data("num");
				var action = "deleteaction";
				
				$.post("eatfood.do", {action : action, num : num}, function(){
					alert("삭제되었습니다.");
					location.reload();
				});
			}
		});
	});
</script>

<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp"/>

		<div class="panel panel-info">
			<div class="panel-heading">섭취 리스트</div>
			<div class="panel-body productPanel">
				<table class="table text-center table-bordered table-hover">
					<thead>
						<tr>
							<th>No.</th>
							<th>아이디</th>
							<th>제품명</th>
							<th>섭취량</th>
							<th>섭취일자</th>
							<th>act</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="item">
							<tr>
								<td>${item.num}</td>
								<td>${item.id }</td>
								<td>${item.foodName }</td>
								<td>${item.cnt }</td>
								<td>
									<fmt:formatDate value="${item.eatdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
								</td>
								<td>
									<button class="btn btn-danger btn-sm delete_btn" data-num="${item.num}">삭제</button>
								</td>
							</tr>
						</c:forEach>
						<c:if test="${list.size() == 0}">
							<tr>
								<td colspan="6" align="center">공지가 없습니다.</td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>