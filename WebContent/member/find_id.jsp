<%@ page language="java" contentType="text/html; charset=EUC-KR"
   import="java.sql.*" pageEncoding="EUC-KR" errorPage="/error.jsp"%>
<%@ page import="model.dao.MemberDao" %>
<% request.setCharacterEncoding("euc-kr"); %>


<jsp:useBean id="findid" class="model.dto.Member" scope="page"/>
<jsp:setProperty name="findid" property="name"	param="name"/>

<%
 	MemberDao dao = new MemberDao();
	String id = dao.FindId(findid.getName());
	if(id.equals("failfindid") || id==null)
	{%>
		<script type="text/javascript">
		alert("해당 아이디가 존재하지 않습니다.");
		history.go(-1);
		</script>
	<%}else{%>
	<script type="text/javascript">
	var a = "<%= id%>";
	alert("ID는 "+ a + " 입니다.");
	history.go(-1);
	</script>	
	<%} %>



	
	

