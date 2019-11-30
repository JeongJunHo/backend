<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="common.jsp"/>

<script type="text/javascript">
	$(function(){
		var allergy = "${mem.allergy}";
		
		$("input[name=pallergy]").each(function(){
			if(allergy.indexOf($(this).val()) != -1){
				$(this).prop("checked",true);
			}
		});
	});
</script>

<title>회원정보 수정</title>
</head>
<body>
	<div class="container">
		<jsp:include page="menu.jsp" />

		<div class="ex">
			<h2>회원정보 수정</h2>
			<form class="form-horizontal" role="form" method="post"
				action="main.do?action=updatemem">
				<div class="form-group" id="divPassword">
					<label for="pid" class="col-lg-2 control-label">아이디</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="pid"
							name="pid" data-rule-required="true" value="${mem.id }"
							maxlength="30" required="required">
					</div>
				</div>
				
				<div class="form-group" id="divrePassword">
					<label for="ppw" class="col-lg-2 control-label">비밀번호</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="ppw" 
							value="${mem.pw }" name="ppw" data-rule-required="true"
							maxlength="30" required="required">
					</div>
				</div>
				
				<div class="form-group" id="divrePassword">
					<label for="pname" class="col-lg-2 control-label">이름</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="pname"
							value="${mem.name }" name="pname" data-rule-required="true"
							maxlength="30" required="required">
					</div>


				</div>
				
				<div class="form-group" id="divAddress">
					<label for="paddr" class="col-lg-2 control-label">주소</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="paddr" name="paddr"
							value="${mem.addr }" data-rule-required="true" maxlength="50" required="required">
					</div>
				</div>
				
				<div class="form-group" id="divPhoneNumber">
					<label for="ptel" class="col-lg-2 control-label">전화번호</label>
					<div class="col-lg-10">
						<input type="tel" class="form-control onlyNumber" id="ptel"
							value="${mem.tel }" name="ptel" data-rule-required="true"
							placeholder="변경하실 전화번호를 입력해주세요." maxlength="11" required="required">
					</div>
				</div>
				
				<div class="form-group" id="divAllergy">
					<label for="inputAllergy" class="col-lg-2 control-label">알레르기</label>
					<div class="col-lg-10">
						<fieldset>
							<legend>check</legend>
							<label class="checkbox-inline"><input type="checkbox" name="pallergy" value="대두">대두</label>
							<label class="checkbox-inline"><input type="checkbox" name="pallergy" value="땅콩">땅콩</label> 
							<label class="checkbox-inline"><input type="checkbox" name="pallergy" value="우유">우유</label> 
							<label class="checkbox-inline"><input type="checkbox" name="pallergy" value="게">게</label> <br> 
							<label class="checkbox-inline"><input type="checkbox" name="pallergy" value="새우">새우</label> 
							<label class="checkbox-inline"><input type="checkbox" name="pallergy" value="참치">참치</label> 
							<label class="checkbox-inline"><input type="checkbox" name="pallergy" value="년어">연어</label> 
							<label class="checkbox-inline"><input type="checkbox" name="pallergy" value="쑥">쑥</label> <br> 
							<label class="checkbox-inline"><input type="checkbox" name="pallergy" value="소고기">소고기</label> 
							<label class="checkbox-inline"><input type="checkbox" name="pallergy" value="닭고기">닭고기</label> 
							<label class="checkbox-inline"><input type="checkbox" name="pallergy" value="돼지고기">돼지고기</label> <br> 
							<label class="checkbox-inline"><input type="checkbox" name="pallergy" value="복숭아">복숭아</label> 
							<label class="checkbox-inline"><input type="checkbox" name="pallergy" value="민들레">민들레</label> 
							<label class="checkbox-inline"><input type="checkbox" name="pallergy" value="계란흰자">계란흰자</label>
						</fieldset>
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<button type="submit" class="btn btn-info">등록</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>
