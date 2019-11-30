<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="common.jsp"/>
<script type="text/javascript">
	$(function(){
		$("#findid").click(function(){
			if($("input[name=name]").val() == ""){
				$("input[name=name]").focus();
				alert("이름 필요");
				return;
			}
			if($("input[name=tel]").val() == ""){
				$("input[name=tel]").focus();
				alert("전화번호 필요");
				return;
			}
			
			var name = $("input[name=name]").val();
			var tel = $("input[name=tel]").val();
			
			$.ajax({
				url: "main.do",
				data: {
					action : "findId",
					name : name,
					tel : tel
				},
				success: function(ret){
					alert(ret);
				}
			});
		});
	});
</script>

<title>아이디찾기</title>
</head>
<body>
	<div class="container">
		<jsp:include page="menu.jsp"/>
		
		<div class="ex">
			<h2>아이디 찾기</h2>
			<form id="rform" class="form-horizontal" role="form">
				<div class="form-group" id="divName">
					<label for="inputName" class="col-lg-2 control-label">이름</label>
					<div class="col-lg-10">
						<input type="text" class="form-control onlyHangul" id="name"
							data-rule-required="true" placeholder="이름" maxlength="15" name="name" required="required">
					</div>
				</div>
				
				<div class="form-group" id="divPhoneNumber">
					<label for="inputPhoneNumber" class="col-lg-2 control-label">전화번호</label>
					<div class="col-lg-10">
						<input type="tel" class="form-control onlyNumber" id="phoneNumber"
							data-rule-required="true" placeholder="010-xxx-xxxx"
							maxlength="11" name="tel" required="required">
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<button type="button" id="findid" class="btn btn-warning">아이디 찾기</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>


