<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav>
	<a class="brand" href="home.jsp"><strong>SSAFY G2</strong></a>
	<ul>
		<li class="menu">
			회원관리
			<div class="sub_menu">
				<p><a href="registerMem.jsp">회원등록</a></p>
				<p><a href="main.do?action=listmem">회원목록</a></p>
			</div>
		</li>
		<li class="menu">
			제품관리
			<div class="sub_menu">
				<p><a href="registerProduct.jsp">제품등록</a></p>
				<p><a href="product.do?action=listProduct">제품목록</a></p>
			</div>
		</li>
	</ul>
</nav>

<p class="loginInfo" align="right">ID : ${loginId} <a href="main.do?action=logout">로그아웃</a></p>