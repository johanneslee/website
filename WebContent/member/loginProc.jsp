<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" errorPage="/error.jsp"%>
<%@ page import="java.sql.*" %>
<%@ page import="model.dao.MemberDao" %>


<jsp:useBean id="login" class="model.dto.Member" scope="page"/>
<jsp:setProperty name="login" property="id" param="id"/>
<jsp:setProperty name="login" property="passwd" param="passwd"/>


<% 
	MemberDao dao = new MemberDao();
	boolean checklogin = dao.Login(login.getId(),login.getPasswd());
	
	if(checklogin){
		session.setAttribute("userinfo", login.getId());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
	
	else{%>
		<script type="text/javascript">
		alert("ID 와 PW를 확인해주세요");
		history.go(-1);
		</script>
	<% }%>



	