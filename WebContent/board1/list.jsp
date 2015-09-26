<!--board1  게시판 목록 페이지 

게시글 번호 | 제목 | 작성자 | 작성일

제목 클릭 -> 해당 게시글로 이동
-->
<%@ page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.List"%>
<%@ page import="model.dto.Board_1" %>
<%@ page import="java.util.Date" %>
<!--java.lang.NoSuchMethodError 에러 발생 이유
	getDate() 메서드 사용하는데 util.Date import 안해줘서
	발생했던 에러
  -->
<%@ page import="java.util.ArrayList" %>
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
		
		<div class="modal-box view-form"> 
			<div class="modal-content">
				<table align="center" width="95%">
				<tr style="background-color:beige;height:25px">
				<td width="5%" align="center">No.</td>	
				<td width="57%" align="center">제목</td>	
				<td width="13%" align="center">작성자</td>	
				<td width="15%" align="center">Date</td> 
				<td width="10%" align="center">count</td>
				</tr>

				<% ArrayList<Board_1> board_1 = 
					(ArrayList<Board_1>)request.getAttribute("board_1"); %>
				<% for(Board_1 list : board_1) {%>
				<tr>
					<td align="center"><%= list.getNum_1() %></td>
					<td align="center">
						<a href="view.action?no=<%= list.getNum_1() %>">
						<%= list.getTitle() %>
						</a>
					</td>
					<td align="center"><%= list.getId_1() %></td>
					<td align="center"><%= list.getDate() %></td>
					<td align="center"><%= list.getCount() %></td>
				</tr>
				<%} %>
				
				</table>
		
			</br></br></br>
			

				<table align="center">
				<tr>
					<td >
							<input type="submit" value="글쓰기" 
							onclick="javascript:location.href='writeform.jsp';" />
					</td>
				</tr>
				</table>	
		</div>	
	</div>		
		
		
<% pageContext.include("/include/footer.html"); %>
</div>

</body>
</html>