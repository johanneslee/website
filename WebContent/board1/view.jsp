<!--  board1 ����������
������ ����
1. �Խñ� ��ȣ 
2. ����
3. �ۼ���
4. �ۼ���
5. ����

���� / ���� / ���

 -->
<%@ page import="model.dto.Board_1" %>
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
		 
			<table width="95%" cellpadding="5px">
			<%Board_1 board_1 =(Board_1)request.getAttribute("board_1"); %>
			<tr>
				<td width="7%" align="center" style="background-color:beige">No.</td><td colspan="5">&nbsp;<%=board_1.getNum_1() %></td>
			</tr>
			<tr>
				<td width="7%" align="center" style="background-color:beige">����</td><td colspan="5">&nbsp;<%=board_1.getTitle() %></td>
			</tr>
			<tr>
				<td width="7%" align="center" style="background-color:beige">�ۼ���</td><td>&nbsp;<%=board_1.getId_1() %></td>
				<td width="7%" align="center" style="background-color:beige">�ۼ���</td><td>&nbsp;<%=board_1.getDate() %></td> 
				<td width="7%" align="center" style="background-color:beige">��ȸ��</td><td>&nbsp;<%=board_1.getCount() %></td>
			</tr>
			<tr><td colspan="6" width="97%"><hr></td></tr>
			<tr >
				<td colspan="6" width="97%" align="left"><%=board_1.getContents_1() %></td>
			</tr>
			<tr><td colspan="6" width="97%"><hr></td></tr>
			<tr align="left">
				<td align="left" colspan="6"> 
					<input type="button" value="���" onclick="javascript:location.href='list.action';" />	
				
				<%if(board_1.getId_1().equals(session.getAttribute("userinfo"))){ %>
				
					<input type="button" value="����" onclick="javascript:location.href='editform.jsp?no=<%=board_1.getNum_1()%>';" />
				
				
					<input type="button" value="����" onclick="javascript:location.href='delete.action?no=<%=board_1.getNum_1()%>';" />
				
				<%} %>
				</td>
			</tr>
			
			</table>

		</div>
<% pageContext.include("/include/footer.html"); %>
</div>

</body>
</html>