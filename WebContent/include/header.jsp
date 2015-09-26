<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="Stylesheet" type="text/css" href="/finalproject/css/layout.css" />
</head>
<body>

<div class="header">
	<!-- title -->
	<div class="title">JSP Project Board.</div>
	<!-- GNB -->
	<div class="gnb-wrapper">
		<ul class="gnb">
			<li><a href="/finalproject/index.jsp">Home</a></li>
			<li><a href="/finalproject/board1/list.action">Board1</a></li>
			<li><a href="/finalproject/board2/list.action">Board2</a></li>
		</ul>
	</div>
	<!-- extra menu -->
	<div class="extramenu-wrapper">
		<ul class="extramenu">
		<%if(session.getAttribute("userinfo")!=null){ %>
			<li><%=session.getAttribute("userinfo")%>님</li> 
			<li><a href="/finalproject/member/logout.jsp">Logout</a></li>
		<%}else{ %>
			<li><a href="/finalproject/member/login.jsp">Login</a></li>
			
			<li><a href="/finalproject/member/register.jsp">Sign up</a></li>
			<li><a href="/finalproject/member/findidnpw.jsp">Find ID</a></li>
		<%} %>
		</ul>
	</div>
	<div class="clearboth"></div>
</div>

</body>
</html>