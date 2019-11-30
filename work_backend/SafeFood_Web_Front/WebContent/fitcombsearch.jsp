<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="common.jsp"/>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp"/>
		
		<div class="row">
			<div class="col-xs-12"
				style="text-align: right; margin-bottom: 15px;">
				<form action="food.do" class="form-inline" method="get">
					<input type="hidden" name="action" value="fitcombsearch">
					<div class="form-group">
						<input type="number" name="searchCalory" class="form-control" placeholder="칼로리를 입력하세요." value="${param.searchCalory}">
					</div>
					<button type="submit" class="btn btn-info">검색</button>
				</form>
			</div>
		</div>

		<div class="panel panel-info">
			<div class="panel-heading">제품 조합 리스트(오차범위 -5%)</div>
			<div class="panel-body">
				<div class="row productRow">
					<c:forEach items="${list}" var="innerList" varStatus="status">
						<p>${status.count}. 
						<c:forEach items="${innerList}" var="item">
							${item.name} 
						</c:forEach>
						</p>	
					</c:forEach>
					<c:choose>
						<c:when test="${param.searchCalory eq 0}">
							<p align="center" style="color: red;">칼로리를 1 이상 입력해주세요.</p>
						</c:when>
						<c:when test="${list.size() eq 0}">
							<p align="center" style="color: red;">원하는 칼로리의 조합이 없습니다.</p>
						</c:when>
					</c:choose>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"/>
</body>
</html>