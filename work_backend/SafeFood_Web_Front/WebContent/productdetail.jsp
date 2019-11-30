<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="common.jsp"/>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.css"
	integrity="sha256-IvM9nJf/b5l2RoebiFno92E5ONttVyaEEsdemDC6iQA="
	crossorigin="anonymous" />
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>

<script>
	$(document).ready(function() {
		var NUTR_CONT2 = $("#NUTR_CONT2").text();
		var NUTR_CONT3 = $("#NUTR_CONT3").text();
		var NUTR_CONT4 = $("#NUTR_CONT4").text();
		var NUTR_CONT5 = $("#NUTR_CONT5").text();
		var NUTR_CONT6 = $("#NUTR_CONT6").text();
		var NUTR_CONT7 = $("#NUTR_CONT7").text();
		var NUTR_CONT8 = $("#NUTR_CONT8").text();
		var NUTR_CONT9 = $("#NUTR_CONT9").text();

		var data = {
			datasets : [ {
				backgroundColor : [ 'rgba(0, 100, 0, 0.25)',
						'rgba(0, 0, 100, 0.25)',
						'rgba(100, 100, 0, 0.25)',
						'rgba(0, 100, 100, 0.25)',
						'rgba(100, 0, 100, 0.25)',
						'rgba(100, 100, 100, 0.25)',
						'rgba(0, 0, 0, 0.25)',
						'rgba(200, 100, 250, 0.25)' ],
				data : [ NUTR_CONT2, NUTR_CONT3,
						NUTR_CONT4, NUTR_CONT5, NUTR_CONT6,
						NUTR_CONT7, NUTR_CONT8, NUTR_CONT9 ]
			} ],

			labels : [ '탄수화믈', '단백질', '지방', '당류',
					'나트륨', '콜레스테롤', '포화 지방산', '트렌스지방' ]
		};
		var myDoughnutChart = new Chart($("#myChart"), {
			type : 'doughnut',
			data : data
		//						 		    options: options
		});
	});
</script>

<title>상품 상세 정보 </title>

</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp"/>

		<h1 style="text-align: center; font-size: 3em; margin-bottom:">제품 정보</h1>
		<hr style="margin-bottom: 40px;">

		<div class="row productRow">
			<div class="col-xs-12 col-sm-5 col-md-4 col-lg-3">
				<img id="product_img" class="media-object" src="${food.img}" alt="${food.name}" width="250"
					style="margin: 0 auto; background: black;">
				<div class="custom_tooltip" style="background: rgba(105, 105, 105, 0.66); bottom: 0px; color: white; padding: 10px; vertical-align: middle; text-align: center; display:${food.allergyWarning eq true ? 'block;' : 'none;'}">
					<p>주의</p>
					<p style="margin-bottom: 0;"><strong>알러지 제품입니다!</strong></p>
				</div>
			</div>

			<div class="col-xs-12 col-sm-7 col-md-8 col-lg-9">
				<table class="table table-hover">
					<tr>
						<th>제품명</th>
						<td id="product_name">
							${food.name}
						</td>
					</tr>
					<tr>
						<th>제조사</th>
						<td id="product_maker">${food.maker}</td>
					</tr>
					<tr>
						<th>원재료</th>
						<td>
							<p id="product_material">${food.material}</p>
						</td>
					</tr>
					<tr>
						<th>검색빈도</th>
						<td>
							${food.hit}
						</td>
					</tr>
				</table>
				
				<c:if test="${not empty loginid}">
					<form action="eatfood.do" method="post" id="eatFoodForm">
						<input type="hidden" name="action" value="insertaction">
						<input type="hidden" name="id" value="${loginid}">
						<input type="hidden" name="code" value="${food.code}">
						
						<div class="input-group">
							<span class="input-group-addon" id="basic-addon1">수량</span>
							<input type="number" name="cnt" class="form-control" placeholder="수량을 입력하세요." value="1" min="1">
							<span class="input-group-btn">
								<button type="submit" class="btn btn-flat btn-info">
									<i class="glyphicon glyphicon-tag"></i> 추가
								</button>
								<a href="#" class="btn btn-flat btn-info" role="button">
									<i class="glyphicon glyphicon-tag"></i> 찜
								</a>
							</span>
						</div>
					</form>
				</c:if>
			</div>
		</div>

		<h1 style="text-align: center; font-size: 3em;">영양 정보</h1>
		<hr style="margin-bottom: 40px;">
		<div class="row">
			<div class="col-sm-8">
				<canvas id="myChart" style="max-height: 600px; max-width: 600px;"></canvas>
			</div>

			<div class="col-sm-4">
				<table class="table">
					<tr>
						<td>일일 제공량</td>
						<td id="SERVING_WT">${food.supportpereat}</td>
					</tr>

					<tr>
						<td>칼로리</td>
						<td id="NUTR_CONT1">${food.calory}</td>
					</tr>

					<tr>
						<td>탄수화물</td>
						<td id="NUTR_CONT2">${food.carbo}</td>
					</tr>

					<tr>
						<td>단백질</td>
						<td id="NUTR_CONT3">${food.protein}</td>
					</tr>

					<tr>
						<td>지방</td>
						<td id="NUTR_CONT4">${food.fat}</td>
					</tr>

					<tr>
						<td>당류</td>
						<td id="NUTR_CONT5">${food.sugar}</td>
					</tr>

					<tr>
						<td>나트륨</td>
						<td id="NUTR_CONT6">${food.natrium}</td>
					</tr>

					<tr>
						<td>콜레스테롤</td>
						<td id="NUTR_CONT7">${food.chole}</td>
					</tr>

					<tr>
						<td>포화 지방산</td>
						<td id="NUTR_CONT8">${food.fattyacid}</td>
					</tr>

					<tr>
						<td>트렌스지방</td>
						<td id="NUTR_CONT9">${food.transfat}</td>
					</tr>
				</table>
			</div>
		</div>

	</div>

	<jsp:include page="footer.jsp"/>
</body>
</html>