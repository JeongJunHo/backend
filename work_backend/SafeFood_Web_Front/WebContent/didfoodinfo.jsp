<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

		<div class="panel panel-info">
			<div class="panel-heading">찜 리스트</div>
			<div class="panel-body productPanel">
				<table class="table text-center table-bordered table-hover">
					<thead>
						<tr>
							<th>아이디</th>
							<th>제품코드</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="item">
							<tr>
								<td>${item.id}</td>
								<td>${item.code }</td>
							</tr>
						</c:forEach>
						<c:if test="${list.size() == 0}">
							<tr>
								<td colspan="5" align="center">찜목록이 없습니다.</td>
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