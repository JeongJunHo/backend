<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="common.jsp"/>

<title>Main</title>

<style type="text/css">
a:hover {
	background-color: #5BC0DE;
	color: white;
	font-style: normal;
}

a.productName:hover:after {
	color: white;
	background-color: black;
}

.image {
	display: block;
	width: 200%;
	height: auto;
}

.overlay {
	opacity: 0;
	transition: .5s ease;
}

.container:hover .overlay {
	opacity: 0.3;
}

.text {
	font-size: 25px;
	text-align: center;
}
</style>
</head>

<body>
	<div class="container">
		<jsp:include page="header.jsp"/>

		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row productRow">
					<c:forEach items="${list}" var="item" varStatus="status">
						<div class="col-sm-6 col-md-4">
							<div class="thumbnail" style="border:none;">
								<div class="overlay">
									<p class="text">RANK ${status.count}</p>
									<p class="text">${item.name}</p>
								</div>
								<img src="${item.img}" alt="${item.name}">
								<div class="caption text-center">
									<a href="food.do?action=productdetail&code=${item.code}" class="btn btn-lg btn-block">
									<font color="white">상품 정보로 이동 <i class="glyphicon glyphicon-arrow-right"></i></font>
									</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"/>
</body>
</html>