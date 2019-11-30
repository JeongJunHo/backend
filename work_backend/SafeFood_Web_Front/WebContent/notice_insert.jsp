<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

		<h1 style="text-align: center; font-size: 3em; margin-bottom:">공지
			게시판</h1>
		<hr style="margin-bottom: 40px;">

		<div class="panel panel-default">
			<div class="panel-body">
				<form action="board.do?action=insertboard" method="post">
					<div class="form-group">
						<label for="btitle">제목</label>
						<input id="btitle" name ="btitle" type="text" class="form-control" placeholder="제목을 입력해주세요.">
					</div>
					<div class="form-group">
						<label for="bdocument">내용</label>
						<textarea id="bdocument" name="bdocument" class="form-control" rows="15" placeholder="내용을 입력해주세요."></textarea>
					</div>
					
					<div class="row">
						<div class="col-sm-12 text-right">
							<button type="submit" class="btn btn-primary">글쓰기</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"/>
</body>
</html>