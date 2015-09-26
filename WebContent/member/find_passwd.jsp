<%@ page language="java" contentType="text/html; charset=EUC-KR"
   import="java.sql.*" pageEncoding="EUC-KR" errorPage="/error.jsp"%>
<%@ page import="model.dao.MemberDao" %>
<jsp:useBean id="findpw" class="model.dto.Member" scope="page"/>
<jsp:setProperty name="findpw" property="id"	param="id"/>
<jsp:setProperty name="findpw" property="email"	param="email"/>


<%
 	MemberDao dao = new MemberDao();
	String pw = dao.FindPw(findpw.getId(), findpw.getEmail());
	if(pw.equals("failfindpw") || pw==null)
	{%>
		<script type="text/javascript">
		alert("해당 사용자가 존재하지 않습니다.");
		history.go(-1);
		</script>
	<%}else{%>
	<script type="text/javascript">
	var passwd = "<%= pw%>";
	alert("비밀번호는 "+ passwd + " 입니다.");
	history.go(-1);
	</script>	
	<%} %>