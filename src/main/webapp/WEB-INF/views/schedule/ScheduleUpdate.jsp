<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
           <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일정 수정페이지</title>
<style type="text/css">
#sTimeBox,#lTimeBox{
display:  inline-block;}
</style>
</head>
<body>
<h1>일정 수정게시판</h1>
<form action="../schedule/scheduleUpdatePOST" method="post">
			<input type="hidden" name="id" value="s1">	
			<input type="hidden" name="num" value="${view.num}">	
				<table class="addT">
				
		<%-- 			<input type="hidden" name="name" value="${member.name}">	
				<input type="hidden" name="tel" value="${member.phone}">	 	 --%>
							<tr>
								<td class="label2">기한 설정</td></tr>
								<tr>
								<td><input required="required" type="date" id="startDay"
									name="startday" value="${view.startday}">
								<input type="date" id="lastDay"
									name="lastday" value="${view.lastday}"></td>
							</tr>
							<tr>
								<td class="label2">프로젝트 명</td>
								</tr>
								<tr>
								<td><input required="required" type="text" id="title"
									name="title" value="${view.title}"></td>
							</tr>
							<tr>
								<td class="label2">세부 내용</td></tr>
									<tr>
								<td><textarea rows="6" cols="40"
								required="required" id="contents"
									name="pro_contents">${view.pro_contents}</textarea></td>
							</tr>
								<tr>
								<td class="label2">기존 시간 ${view.start_time} ~ ${view.last_time}</td></tr>
								<tr>
								<td>
										<div id="sTimeBox" class="sTime_box">일정 시간
										<select id="startTime" name="start_time" required="required" value="${view.start_time}">
											<c:forEach begin="9" end="21" var="i" varStatus="num">
												<option id="sTime${num.count}" class="s_time">${i}:00</option>
											</c:forEach>
										</select>
									</div>
									<div id="lTimeBox" class="lTime_box">
											<select id="lastTime" name="last_time" required="required" value="${view.last_time}">
											<c:forEach begin="9" end="21" var="i" varStatus="num">
												<option id="lTime${num.count}"  class="l_time">${i}:00</option>
											</c:forEach>
										</select>
									</div>
								</td>
							</tr>
<!-- 							<tr>
							<td class="label2">참석자 </td>
							</tr>
							<tr>
							<td><input type="text" id="partner"
									name="partner"></td>
							</tr> -->
						</table>
						<table>
						<tr><td class="label2">일정 색상</td><tr>
						<tr><td>
						초록<input type="radio" name="color" checked="checked" value="rgb(22,160,133)">
						빨강<input type="radio" name="color" value="rgb(255,0,0)">
						노랑<input type="radio" name="color" value="rgb(225,225,54)">
						파랑<input type="radio" name="color" value="rgb(3,0,102)">
						갈색<input type="radio" name="color" value="rgb(130,0,0)">
						검정<input type="radio" name="color" value="rgb(0,0,0)">
						</td></tr>
						</table>
							<button id="submitBtn" class="btn">등록하기</button>
</form>
</body>
</html>