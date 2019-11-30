<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="main.do?action=fileup" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="pname" id="pname">
				</td>
			</tr>
			<tr>
				<td>파일</td>
				<td>
					<input type="file" name="pfile" id="pfile">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="전송">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>