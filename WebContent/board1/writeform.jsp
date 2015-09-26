<!-- 
board1 글작성 페이지
작성자, 제목, 내용

 -->
<%@ page import="java.util.Date" %>
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

<% Date date = new Date(); %>	

<div class="container">
<% pageContext.include("/include/header.jsp"); %>
		
		<div class="content"> 
		<form action="write.action" method="post">
			<table>
				<tr>
					<td>작성자</td>
					<td><input type="hidden" name="writer" value=<%=session.getAttribute("userinfo") %>>
						<%=session.getAttribute("userinfo") %>
					</td>
				</tr>
				<tr>
					<td>제목</td><td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea name="contents" style="width:580px" rows="15"></textarea>
					</td>
				</tr>
				<tr>
				<td><input type="submit" value="작성"></td>
				<td><a href="list.action"><input type="button" value="취소"/></a></td>
				</tr>
			</table>	
		</form>

<% pageContext.include("/include/footer.html"); %>
</div>

</body>
</html>