<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="common.jsp"/>
<title>알러지 정보 페이지</title>
</head>

<body>
	<div class="container">
		<jsp:include page="header.jsp" />

		<div class="row">
			<div class="col-xs-12"
				style="text-align: right; margin-bottom: 15px;"></div>
		</div>

		<div class="panel panel-info">
			<div class="panel-heading">알러지 정보</div>
			<div class="panel-body">
				<div class="row productRow">
					<c:forEach items="${map}" var="amp" varStatus="status">
						<p>${status.count}.
							${amp.key} : ${amp.value }<br>
						</p>
					</c:forEach>

				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>