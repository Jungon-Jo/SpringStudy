<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.ArrayList"
	pageEncoding="UTF-8"%>
<% ArrayList<Object> wordList = new ArrayList<Object>(); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>브롤 단어장</title>
</head>
<script>

</script>
<body>
	<h1>단어짱!</h1>
	<hr>
	<section>
		<h1>단어 등록</h1>
		<form action=wordInsert method=RequestMethod.POST>
			<input name=word action=word method=RequestMethod.POST>
			<input name=wordMeaning action=wordMeaning method=RequestMethod.POST>
			<button type=submit>입력</button>
		</form>
		<hr>
		<p>
			${wordList}
		</p>
	</section>
</body>
</html>