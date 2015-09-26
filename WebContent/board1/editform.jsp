<!-- 
board1 글수정 페이지
 -->
<%@ page import="java.util.Date" %>
<%@ page import="model.dto.Board_1" %>
<%@ page import="model.dao.Board_1Dao" %>
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
		
	<div class="content"> 
	<%
	Board_1Dao dao = new Board_1Dao();
	Board_1 board = dao.getViewByListNo(Integer.parseInt(request.getParameter("no")));
	%>
		<form action="edit.action" method="post">
		<input type="hidden" name="no" value=<%=board.getNum_1() %>>
			<table>
				<tr>
					<td>작성자</td><td><%= board.getId_1() %></td>
				</tr>
				<tr>
					<td>제목</td><td><input type="text" name="title" value=<%= board.getTitle() %>></td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea name="contents" style="width:580px" rows="15"><%= board.getContents_1() %></textarea>
					</td>
				</tr>
				<tr>
				<td><input type="submit" value="수정"></td>
				<td><a href="list.action"><input type="button" value="취소"> </a></td>
				</tr>
			</table>	
		</form>
		
<% pageContext.include("/include/footer.html"); %>
</div>

</body>
</html>