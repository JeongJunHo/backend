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
			<div class="panel-heading">주의 리스트</div>
			<div class="panel-body">
				<div class="row productRow">
					<c:forEach items="${map}" var="item" varStatus="status">
						<h4>${status.count}.
						<span style="color: red; font-size: 1.5em;">${item.key}</span>가 첨가된 제품
						</h4>
						<p>
						<c:forEach items="${item.value}" var="vo">
							<span style="margin-right: 5px;">${vo.name}</span>
						</c:forEach>
						<c:if test="${item.value.size() == 0}">
							알러지를 유발하는 제품이 없습니다!
						</c:if>
						</p>	
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"/>
</body>
</html>