<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시간표</title>
</head>
<body>
	오후 일정 : 5시 30분 까지 숨도 쉬지 말고 화장실도 가지 말고 잠도 자지 말고, 브롤스타즈 하기
	<a href="<%=request.getContextPath()%>/viewMessage?time=4&name=human">[시간표 보기]</a>
	<form action=viewMessage method=post>
		<input type=text name=time>
		<input type=text name=name>
		<input type=submit value=전송>
	</form>
	
</body>
</html>