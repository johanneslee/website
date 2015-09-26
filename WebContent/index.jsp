<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" errorPage="/error.jsp"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>WebProgramming Team Project</title>
<link rel="Stylesheet" type="text/css" href="/finalproject/css/layout.css" />
</head>
<body>
	<div class="container">
		<% pageContext.include("/include/header.jsp"); %>
		
		<div class="content">
			<!-- 여기 내용 들어가면 됨 -->
			<h1>Project Team 2</h1>
			<h2>Member profile</h2>
			<div class="member-wrapper">
				<div class="member">
					<div class="member-profile"
						style="background: url(./image/w.jpg); background-size: cover; background-position: 50%"></div>
					<span class="member-text-row name">09 han.kwon</span> <span
						class="member-text-row major">chemical science</span> <span
						class="member-text-row part">module development<br />(member
						db design, control)
					</span> <span class="member-text-row email">itqa@naver.com</span>
				</div>
				<div class="member">
					<div class="member-profile"
						style="background: url(./image/s.jpg); background-size: cover; background-position: 50%"></div>
					<span class="member-text-row name">07 sunho.hwang</span> <span
						class="member-text-row major">computer engineering</span> <span
						class="member-text-row part">module development<br />(board1,
						db design)
					</span> <span class="member-text-row email">sunho1026@naver.com</span>
				</div>
				<div class="member">
					<div class="member-profile"
						style="background: url(./image/k.jpg); background-size: cover; background-position: 50%"></div>
					<span class="member-text-row name">07 gyeongcheol.na</span> <span
						class="member-text-row major">computer engineering</span> <span
						class="member-text-row part">module development<br />(board2,
						db design)
					</span> <span class="member-text-row email"></span>
				</div>
				<div class="member">
					<div class="member-profile"
						style="background: url(./image/h.jpg); background-size: cover; background-position: 50%"></div>
					<span class="member-text-row name">07 junho.lee</span> <span
						class="member-text-row major">computer engineering</span> <span
						class="member-text-row part">module development<br />(member
						db design, control)
					</span> <span class="member-text-row email"></span>
				</div>
				<div class="member">
					<div class="member-profile"
						style="background: url(./image/j.jpg); background-size: cover; background-position: 50%"></div>
					<span class="member-text-row name">07 juwon.lee</span> <span
						class="member-text-row major">computer engineering</span> <span
						class="member-text-row part">page design&development<br />(page
						skeleton, css)
					</span> <span class="member-text-row email">ashon8813@gmail.com</span>
				</div>
			</div>
			<!-- 여기 내용 들어가면 됨 end -->
			<div class="clearboth"></div>
		</div>
		
		<% pageContext.include("/include/footer.html"); %>
	</div>


</body>
</html>