<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>로그인</title>

<script type="text/javascript">
	$(function(){
		if("${param.res}" == "f"){
			alert("로그인 실패");
		}
		
		$("#login_form").submit(function(){
			if($("#id").val() == ""){
				alert("아이디를 입력해주세요.");
				$("#id").focus();
				return false;
			}
			if($("#pwd").val() == ""){
				alert("비밀번호를 입력해주세요.");
				$("#pwd").focus();
				return false;
			}
		});
	});
	
</script>
</head>
<body>
	<div id="outer" style="width: 300px;">
		<h1>SSAFY G2</h1>
		<form id="login_form" action="main.do" method="post">
			<input type="hidden" name="action" value="login">
			<div class="label_div mb-15">
				<label>ID</label>
			</div>
			<input type="text" id="id" name="id">
			<br/>
			<div class="label_div mb-15">
				<label>PW</label>
			</div>
			<input type="password" id="pwd" name="pwd">
			<button class="submit_btn mb-15" type="submit">로그인</button>
		</form>
		
		<a href="registerMem.jsp">회원등록</a><br>
	</div>
</body>
</html>