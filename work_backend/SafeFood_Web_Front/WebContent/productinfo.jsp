<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="common.jsp"/>

<style type="text/css">
a.productName:link {
	color: black;
	text-decoration: none;
}

a.productName:visited {
	color: black;
	text-decoration: none;
}

a.productName:hover {
	color: #337ab7;
	text-decoration: underline;
}
</style>

<script>
	$(document).ready(function() {
		$(".productPanel").on('mouseenter', '.productRow', function() {
			$(this).find(".custom_tooltip").stop(true, true).fadeIn({
				queue : false
			}).css('display', 'none').slideDown({
				duration : 'fast',
				queue : false
			});
		}).on('mouseleave', '.productRow', function() {
			$(this).find(".custom_tooltip").stop(true, true).slideUp({
				duration : 'fast',
				queue : false
			}).fadeOut({
				duration : 'fast',
				queue : false
			});
		});
	});
</script>

<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp"/>
		
		<div class="row">
			<div class="col-xs-12"
				style="text-align: right; margin-bottom: 15px;">
	
				<form action="food.do" class="form-inline" method="get">
				<c:forEach var="r" items="${rList }">
						<span class="searchRank" style="">상품명:${r.sname }</span>
						<span class="searchRank" style="">검색횟수:${r.count }</span>
				</c:forEach>
					<input type="hidden" name="action" value="productinfo">
					<div class="form-group">
						<select name="searchType" class="form-control">
							<option value="name" ${param.searchType eq 'name' ? 'selected' : ''}>상품명</option>
							<option value="maker" ${param.searchType eq 'maker' ? 'selected' : ''}>제조사</option>
							<option value="material" ${param.searchType eq 'material' ? 'selected' : ''}>재료명</option>
						</select>
					</div>
					<div class="form-group">
						<input type="text" name="searchText" class="form-control" placeholder="검색어를 입력하세요." value="${param.searchText}">
					</div>
					<button type="submit" class="btn btn-info">검색</button>
				</form>
			</div>
		</div>

		<div class="panel panel-info">
			<div class="panel-heading">제품 리스트</div>
			<div class="panel-body productPanel">
				<c:forEach items="${list}" var="item">
					<div class="row productRow">
						<div class="col-xs-12 col-sm-4 col-md-3" style="max-height: 250px;">
							<img class="media-object" src="${item.img}" alt="${item.name}" width="200">
							<div class="custom_tooltip" style="position: absolute; width: 200px; background: #696969a8; bottom: 0; color: white; padding: 10px; vertical-align: middle; text-align: center; display: none;">
							<p>${item.name}</p>
							<p style="margin-bottom: 0;"><strong>${item.maker}</strong></p>
							</div>
						</div>
						<div class="col-xs-12 col-sm-8 col-md-9">
							<h3>
								<a class="productName" href="food.do?action=productdetail&code=${item.code}">${item.name}</a>
								<span style="float: right;">view : ${item.hit}</span>
							</h3>
							<hr>
							<p>
								${item.material}
							</p>
							<div class="btn-group" role="group">
								<a class="btn btn-flat btn-sm btn-info" href="didfood.do?action=takefood&code=${item.code }"><i class="glyphicon glyphicon-tag"></i> 찜</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>