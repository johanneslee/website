<%@ page language="java" contentType="text/html; charset=EUC-KR"
   import="java.sql.*" pageEncoding="EUC-KR" errorPage="/error.jsp"%>


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
	<div class="modal-box find-form">
		<div class="modal-title">
			<h1>Find id</h1>
		</div>
		<div class="modal-content">
			
			<form name="forgotId" method="post" action="find_id.jsp">
			<!-- name input -->
			<label for="name">Your Name</label><input type=text id="user-name" name="name"/>
			<br/>
			<!-- submit -->
			<input type="submit" name="submit-findid" value="find id">
			</form>
		</div>	
		<div class="modal-title">
			<h1>Find password</h1>
		</div>	
		<div class="modal-content">
			<form name="forgotPasswd" method="post" action="find_passwd.jsp">
			<!-- id input -->
			<label for="id">Your ID</label><input type="text" id="user-id" name=id>
			<br/>
			<!-- email input -->
			<label for="email">Your e-mail</label><input type=text id="user-email" name=email>
			<br/>
			<!-- submit -->
			<input type=submit name="submit-findpasswd" value="find password">
			</form>
		</div>
	</div>
<% pageContext.include("/include/footer.html"); %>
</div>
</body>
</html>