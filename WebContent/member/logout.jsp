<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" errorPage="/error.jsp"%>
    
<%session.invalidate(); %>    

<script type="text/javascript">
		alert("로그아웃 되었습니다.");
		parent.location.replace("/finalproject/index.jsp");
</script>


    