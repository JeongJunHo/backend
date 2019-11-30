<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="common.jsp"/>
<title>회원정보 삭제</title>
</head>
<body>
	<div class="container">
		<jsp:include page="menu.jsp"/>
		
		<div class="ex">
			<h2>회원정보 삭제</h2>
			<form class="form-horizontal" role="form" method="post"
				action="main.do?action=deletemem">
	
				<div class="form-group">
					<label for="pid">아이디</label> <input type="text" class="form-control"
						id="pid" name ="pid" placeholder="삭제하실 아이디를 입력해주세요">
				</div>
				<div class="form-group">
					<label for="ppw">패스워드</label> <input type="password"
						class="form-control" id="ppw" name="ppw" placeholder="비밀번호를 입력해주세요">
				</div>
	
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<button type="submit" class="btn btn-danger">삭제</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>