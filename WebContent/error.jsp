<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isErrorPage="true"%>
<% response.setStatus(200); %>


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
		
		<div class="error">
			an error occured :)<br /> <span class="errorcode"><%=pageContext.getErrorData().getStatusCode()%></span>
		</div>
		
		<% pageContext.include("/include/footer.html"); %>
	</div>


</body>
</html>