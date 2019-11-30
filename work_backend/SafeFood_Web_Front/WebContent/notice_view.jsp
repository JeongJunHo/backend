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
		<jsp:include page="header.jsp" />

		<h1 style="text-align: center; font-size: 3em; margin-bottom:">공지
			게시판</h1>
		<hr style="margin-bottom: 40px;">

		<div class="panel panel-info">
			<div class="panel-heading">
				<strong>${board.title }</strong>
			</div>
			<div class="panel-body">
				<p>${board.document }</p>
			</div>
			<div class="panel-footer text-right">
				<c:if test="${loginid eq board.id}">
					<a href="board.do?action=infoupdateboard&bnum=${board.num }&btitle=${board.title }" class="btn btn-info btn-flat">수정</a>
					<a href="board.do?action=deleteboard&bnum=${board.num }" class="btn btn-danger btn-flat">삭제</a>
				</c:if>
				<a href="board.do?action=listboard" class="btn btn-primary btn-flat">목록</a>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>