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
		
		<div class="panel panel-info">
			<div class="panel-heading">원재료 사용 횟수</div>
			<div class="panel-body">
				<div class="row productRow">
					<c:forEach items="${map}" var="item" varStatus="status">
						<p>${status.count}. ${item.key} ${item.value}</p>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"/>
</body>
</html>