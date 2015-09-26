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
	<div class="modal-box register-form">
	<div class="modal-title">
		<h1>Sign up</h1>
	</div>
	<div class="modal-content">
	
		<!-- resgister form -->
		<form name="a" id="register" method="post" action="joinProc.jsp">
			<!-- id input -->
			<label for="id">Your ID</label><input type="text" id="user-id" name="id" />
			</br>
			<!-- pass input -->
			<label for="pass">Your Password</label><input type="password" id="user-pass" name="passwd" />
			</br>
			<!-- pass confirm input 
			<label for="pass-confirm">Confirm your password</label><input type="password" id="pass-confirm" name="pass-conf" />
			</br> -->
			<!-- name input -->
			<label for="name">Your Name</label><input type="text" id="user-name" name="name" />
			</br>
			<!-- email input -->
			<label for="email">Your E-mail</label><input type="email" id="user-email" name="email" />
			</br>
			<!-- submit -->
			<input type="submit" name="submit-login" value="register" />
		</form>
	</div>
	
</div>
<% pageContext.include("/include/footer.html"); %>
</div>

</body>
</html>