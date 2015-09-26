<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" errorPage="/error.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>WebProgramming Team Project</title>
<link rel="Stylesheet" type="text/css" href="/finalproject/css/layout.css" />
</head>
<body>
<div class="container">
<% pageContext.include("/include/header.jsp"); %>


	<div class="modal-box login-form">
		<div class="modal-title">
			<h1>Member Login</h1>
		</div>
		<div class="modal-content">
		
		<!-- login form -->
			<form name="a" method="post" action="/finalproject/member/loginProc.jsp">
				<!-- id input -->
				<label for="id">ID</label></br><input type="text" id="user-id" name="id" />
				
				<!-- password input -->
				<label for="pass">Password</label><input type="password" id="user-pass" name="passwd" />
				
				<!-- submit -->
				<input type="submit" name="login" value="login" />
			</form>
		</div>
	</div>
	
	
<% pageContext.include("/include/footer.html"); %>
</div>	
</body>
</html>