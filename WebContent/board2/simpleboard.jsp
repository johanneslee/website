<!--  �Խ��� ��� ������ 

�Խñ� ��ȣ | �ۼ��� | ���� | �ۼ���

���� Ŭ�� -> �ش� �Խñ۷� �̵�
-->
<%@ page import="model.dto.Board_2"%>
<%@ page import="java.util.Date"%>
<!--java.lang.NoSuchMethodError ���� �߻� ����
	getDate() �޼��� ����ϴµ� util.Date import �����༭
	�߻��ߴ� ����
  -->
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" errorPage="/error.jsp"%>
	
<%
	Date date = new Date();
%>	
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
		
		<div class="table-form"> 
		<div class="table-content">
		<form action="write.action" method="post">
			<table align="center" width="700px">
				<tr>
					<td width="10%" align="center">�ۼ���</td>
					<td width="5%"><input type="hidden" name="writer" value=<%=session.getAttribute("userinfo") %>>
						<%=session.getAttribute("userinfo") %>
					</td>
					<td width="5%" align="right">����&nbsp;</td>
					<td width="70%">
					<textarea name="contents" style="width: 95%" rows="1"></textarea>
					</td>
					<td width="10%"><input type="submit" value="�ۼ�"></td>
				</tr>
			</table>
		</form>

			<table align="center" width="700px">
				<tr><td colspan="5"><hr></td></tr>
				<tr align="center" style="background-color:beige;height:25px">
					<td width="10%">No.</td>
					<td width="10%">�ۼ���</td>
					<td width="50%">����</td>
					<td width="10%">Date</td>
					<td width="10%"></td>
				</tr>
				<%
					ArrayList<Board_2> board_2 = (ArrayList<Board_2>) request
							.getAttribute("board_2");
				%>
				<%
					for (Board_2 blist : board_2) {
				%>
				<tr >
					<td width="10%" align="center"><%=blist.getNum_2()%></td>
					<td width="10%" align="center"><%=blist.getId_2()%></td>
					<td width="50%" align="center"><%=blist.getContents_2()%></td>
					<td width="10%" align="center"><%=blist.getDate()%></td>
					
					<%-- �α����� ȸ���� �ۼ��ڰ� ������쿡�� ���� ��ư ��� --%>
					<%if(blist.getId_2().equals(session.getAttribute("userinfo"))){ %>
					<td width="10%" align="center">
					<input type="image" src="/finalproject/image/delete.jpg" value="����" onclick="javascript:location.href='delete.action?no=<%=blist.getNum_2() %>';" />
					</td>
					<%} %>
					
				</tr>
				<%
					}
				%>

			</table>
		</div>
	</div>	
<% pageContext.include("/include/footer.html"); %>
</div>

</body>
</html>