<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<div class="panel panel-default">
			<div class="panel-body">
				<table class="table text-center table-bordered table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>아이디</th>
							<th>제목</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${blist}" var="list">
							<tr>
								<td>${list.num }</td>
								<td>${list.id }</td>
								<td><a href="board.do?action=infoboard&btitle=${list.title }">${list.title }</a></td>
								<td>${list.hit }</td>
							</tr>
						</c:forEach>
						<c:if test="${blist.size() == 0}">
							<tr>
								<td colspan="4" align="center">공지가 없습니다.</td>
							</tr>
						</c:if>
					</tbody>
				</table>
				<div class="row">
					<div class="col-sm-12 text-right">
						<c:if test="${not empty loginid}">
							<a href="notice_insert.jsp" class="btn btn-info btn-flat">글쓰기</a>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>