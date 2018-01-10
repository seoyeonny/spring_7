<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <style>
#day_sc{
text-align: center;
border-bottom: 2px double #16A085;
margin: 0 auto;
}
#maimy{
font-weight :bolder;
text-decoration: underline;
font-size: 1.5em;}
</style>
<script type="text/javascript">
$(function() {	
	
	$("#deleteBtn").click(function(){
		var schedule_num = $(this).val();
		$.ajax({
			type: "GET",
			url: "./scheduleDeleteOne",  
			data:{
				num: schedule_num,
			},
			success: function(){
				//opener.location.reload();
				location.reload();
			}
		});
	});
	
});
</script>
<div id="maimy"style="text-align: center;">일정관리</div>
<input type="hidden" value="s1" name="id">
<input type="hidden" value="${dto.num}" name="num">
    <c:if test="${not empty list}">
    <c:forEach items="${list}" var="dto">
	<table id="day_sc" >
	<tr><td>no.</td>
       <td>${dto.num}</td></tr>
	<tr><td>프로젝트명</td>
    	<td><h5>${dto.title}</h5></td>
	</tr>	
	<tr><td>상세설명</td>
	<td>${dto.pro_contents}</td>
	</tr>
	<tr><td>기간</td>
	<td><p>${dto.startday} ~ ${dto.lastday}</p></td>
	</tr>
	<tr><td>시간</td>
    	<td><p>${dto.start_time}~${dto.last_time}</p>
    	</td></tr>
    		<tr><td colspan="2"></td></tr>
       	<tr><td colspan="2"><button id="updateBtn" onclick="location.href='./ScheduleUpdate?num=${dto.num}'">수정</button>
    	<button value="${dto.num}" id="deleteBtn">삭제</button> </td></tr>
	</table>
    	  </c:forEach>
    	  </c:if>
    	  <c:if test="${empty list}">
  <p> 일정을 추가해주세요.</p></c:if>