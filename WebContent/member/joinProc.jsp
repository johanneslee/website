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
 	alert("이미 존재하는 ID 입니다.");
 	history.go(-1);
 	</script>
	 
 <%}else{
 	if(dao.Join(join)){ %>
 	<script type="text/javascript">
	alert("회원가입이 완료되었습니다.");
	parent.location.replace("/finalproject/index.jsp");
	</script>
	<%}else{ %>
	<script type="text/javascript">
 	alert("회원가입 실패. 빠진항목이 있나 확인 바랍니다.");
 	history.go(-1);
 	</script>
 	<%} %>
<%}%>




	