<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" errorPage="/error.jsp"%>
<%@ page import="java.sql.*" %>
<%@ page import="model.dao.MemberDao" %>

<% request.setCharacterEncoding("euc-kr"); %>

<jsp:useBean id="join" class="model.dto.Member" scope="page"/>
<jsp:setProperty name="join" property="*"/>


<%
 MemberDao dao = new MemberDao();
 if(dao.checkId(join.getId()))
 {%>
 	<script type="text/javascript">
 	alert("�̹� �����ϴ� ID �Դϴ�.");
 	history.go(-1);
 	</script>
	 
 <%}else{
 	if(dao.Join(join)){ %>
 	<script type="text/javascript">
	alert("ȸ�������� �Ϸ�Ǿ����ϴ�.");
	parent.location.replace("/finalproject/index.jsp");
	</script>
	<%}else{ %>
	<script type="text/javascript">
 	alert("ȸ������ ����. �����׸��� �ֳ� Ȯ�� �ٶ��ϴ�.");
 	history.go(-1);
 	</script>
 	<%} %>
<%}%>




	