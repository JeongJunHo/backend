<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>회원 등록</title>

<script type="text/javascript">
	function check(){
		var id = pid.value;
		if(id.length < 3){
			alert("ID가 너무 짧습니다.");
			pid.focus();
			return;
		}
	}
</script>
</head>
<body>
	<div id="outer">
		<c:if test="${not empty loginId}">
			<%@ include file="menu.jsp" %>
		</c:if>
		
		<h1 align="center">회원 등록</h1>
		
		<form action="main.do" method="POST" id="rform">
			<input type="hidden" name="action" value="registermem">
			<table border="1" class="mb-15">
				<tr>
					<th>ID</th>
					<td>
						<input type="text" name="pid" id="pid" required="required">
					</td>
				</tr>
				<tr>
					<th>PW</th>
					<td>
						<input type="password" name="ppw" required="required">
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" name="pname" required="required">
					</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>
						<input type="text" name="ptel" required="required">
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<label for="man"><input id="man" type="radio" name="pgender" value="남" checked="checked">남</label>
						<label for="woman"><input id="woman" type="radio" name="pgender" value="여">여</label>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="등록" onclick="check()">
						<input type="reset" value="reset">
					</td>
				</tr>
			</table>
		</form>
		
		<c:if test="${empty loginId}">
			<a href="index.jsp">취소</a>
		</c:if>
		
	</div>
</body>
</html>