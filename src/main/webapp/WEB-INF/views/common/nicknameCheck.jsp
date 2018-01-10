<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	
	
	$("#useID").click(function(){
		var id=$("#partner").val();
		 window.opener.$("#partner").val(partner);
		 window.opener.$("#check").val("ok");
		 window.close();
	
	});
	
	$("#partner").keyup(function(){
		var id=$("#partner").val();
		location.href="../common/nicknameCheck?partner="+partner;	
		
	});
	
});
	

</script>
</head>
<body>
<h3>ID Check</h3>
<form action="">
<input type="text" id="partner" name="partner" value="${requestScope.nickname}">
</form>
<div>
<c:if test="${requestScope.result eq true}">
<h4>리스트에 없는 ID입니다</h4>
<input type="button" value="사용" id="useID">
</c:if>
<c:if test="${requestScope.result eq false}">
<h4>리스트에 있는 ID입니다. </h4>
</c:if>
</div>
</body>
</html>