<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>회원 수정</title>

<script type="text/javascript">
	function updateMem(){
		rform.action="main.do?action=updatemem";
		rform.submit();
	}
	
	function deleteMem(){
		var id = pid.value;
		location.href = "main.do?action=deletemem&pid=" + id;
	}
</script>
</head>
<body>
	<div id="outer">
		<%@ include file="menu.jsp" %>
		
		<h1 align="center">회원 정보</h1>
		
		<form action="main.do" method="POST" id="rform">
			<table border="1" class="mb-15">
				<tr>
					<th>ID</th>
					<td>
						<input type="text" name="pid" id="pid" value="${mem.id}" readonly="readonly" style="background: #dcdcdc;">
					</td>
				</tr>
				<tr>
					<th>PW</th>
					<td>
						<input type="password" name="ppw" value="${mem.pw}">
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" name="pname" value="${mem.name}">
					</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>
						<input type="text" name="ptel" value="${mem.tel}">
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<label for="man">
							<input id="man" type="radio" name="pgender" value="남" ${mem.gender eq '남' ? 'checked' : ''}> 남
						</label>
						<label for="woman">
							<input id="woman" type="radio" name="pgender" value="여" ${mem.gender eq '여' ? 'checked' : ''}> 여
						</label>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="수정" onclick="updateMem()">
						<input type="button" value="삭제" onclick="deleteMem()">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>