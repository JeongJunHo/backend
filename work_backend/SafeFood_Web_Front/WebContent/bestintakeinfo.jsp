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
			<div class="panel-heading">제품 리스트</div>
			<div class="panel-body">
				<div class="row productRow">
					<c:forEach items="${list}" var="item">
						<div class="col-sm-6 col-md-6">
							<div class="thumbnail">
								<img src="${item.img}" alt="${item.name}" style="max-width: 50%;">
								<div class="caption">
									<h3>
										${item.name}
										<span style="float: right;">view : ${item.hit}</span>
									</h3>
									<p class="small material">${item.material}</p>
									<div class="btn-group btn-group-justified" role="group">
										<a href="#" class="btn btn-flat btn-sm btn-info" role="button"><i class="glyphicon glyphicon-tag"></i> 찜</a>
									</div>
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