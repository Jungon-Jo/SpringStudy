<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<!-- 문자 인코딩 방식 : 세계적으로 사용(한글 2바이트) -->
<!-- euc-kr : 한국에서 사용(한글 3바이트) -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<style>
body {
	/* body 바깥쪽 document와의 사이 */
	margin: 0px;
	width: 1280px;
	height: 1024px;
	border: 1px solid black;
	font-family: pretendard;
}

header {
	/* display: inline-block; */
	float: left;
	width: 1280px;
	height: 100px;
	background-color: black;
	padding-top: 20px;
	box-sizing: border-box; /* 박스 크기를 고정시켜 padding을 주더라도 늘어나지 않는다. */
}

nav {
	width: 1280px;
	height: 30px;
	background-color: rgb(39, 39, 39);
	/* display: inline-block; */
	float: left;
}

section {
	width: 70%;
	height: 400px;
	background-color: rgb(53, 53, 53);
	/* display: inline-block; */
	float: left;
	padding-top: 10px;
	/* padding-left: 10px; */
	box-sizing: border-box;
}

aside {
	width: 30%;
	height: 400px;
	background-color: rgb(66, 66, 66);
	/* display: inline-block; */
	float: left;
	padding-top: 100px;
	box-sizing: border-box;
}

#display {
	width: 100%;
	height: 400px;
	background-color: rgb(94, 94, 94);
	display: inline-block;
}

footer {
	width: 100%;
	height: 30px;
	border: 1px dotted;
	/* display: inline-block; */
	float: left;
	text-align: center; /* 글자 가운데 정렬 */
}

.header_01 { /* margin은 header와의 간격 */
	color: white;
	width: 1000px;
	height: 30px;
	/* border: 1px solid; */
	text-align: center;
	margin: 0px auto; /* margin: 0px auto; 는 가운데 정렬의 의미를 가지고 있다. */
}

.header_01 h2 {
	display: inline;
}

input[type="text"], input[type="submit"] {
	border-radius: 0%;
}

nav ul {
	/* border: 1px solid white; */
	margin-top: 3px;
	/* display: inline; */
}

nav ul li {
	display: inline-block;
	width: 100px;
	margin-left: 1%;
	text-align: center;
	border: 1px solid;
}

nav ul li:hover {
	background-color: rgb(134, 37, 37);
}

.display_01 {
	width: 24%;
	height: 150px;
	margin-top: 10px;
	margin-left: 0.67%;
	float: left;
	border: 1px solid white;
	text-align: center;
	background-color: rgb(97, 14, 14);
	color: white;
}

hr {
	margin: 1% 1%;
}

aside div {
	width: 300px;
	height: 200px;
	margin: 0px auto;
	background-color: rgb(153, 83, 83);
}

table {
	border: 1px solid;
	width: 300px;
	height: 200px;
}

table tr, td, th {
	border: 1px solid;
}

td {
	text-align: center;
}

th {
	background-color: rgb(148, 66, 66);
}

th:hover {
	background-color: white;
}
</style>
<script>
	let cnt = 0;
	const click = document.getElementById("click");
	function clickCount() {
		cnt += 1;
		document.getElementById("viewCount").innerHTML = '${cnt}';
		click.addEventListener("click", clickCount)
	}
</script>
<body>
	<!-- <div id="header"></div> -->
	<!-- 시멘틱 태그 사용 -->
	<header>
		<div class="header_01">
			<h2>프로그램 왜 이리 맛나냐~~</h2>
		</div>
		<div class="header_01">
			<form action="" method="">
				<input type="text" size="50"> <input type="submit"
					value="search">
			</form>
		</div>
	</header>
	<nav>
		<ul>
			<!-- ul의 자식이 4개 -->
			<li><span>오늘의 그림</span></li>
			<li><span>게시판</span></li>
			<li><span>홈으로</span></li>
			<li><span>홈으로</span></li>
		</ul>
	</nav>
	<section>
		<div>
			<span style="margin: 1% 1%;">게시판</span>
			<hr>
			<table>
				<tr>
					<th>No</th>
					<th>작성자</th>
					<th>제목</th>
					<th>조회수</th>
					<th>수정/삭제</th>
				</tr>
				<c:forEach items="${noticeVO}" var="noticeVO" varStatus="status">
					<tr>
						<td scope="row">${status.count}</td>
						<td>${noticeVO.writer}</td>
						<td><a id="click">${noticeVO.title}</a></td>
						<td id="viewCount"></td>
						<td>수정/<a
							href="deleteNotice?noticeNumber=${noticeVO.sequence}">삭제</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</section>
	<aside>
		<div>
			<form action="" method="">
				<table>
					<!-- login table -->
					<tr>
						<td colspan="2">회원이 되어주셔서 감사합니다.</td>
					</tr>
					<tr>
						<td>ID</td>
						<td><input type="text"></td>
					</tr>
					<tr>
						<td>PASSWORD</td>
						<td><input type="password"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="button" value="가입"> <input
							type="button" value="로그인"></td>
					</tr>
				</table>
			</form>
		</div>
	</aside>
	<div id="display">
		<p style="margin-left: 10px;">율이의 맛집 List</p>
		<hr>
		<div class="display_01">
			<h3>최가네</h3>
			<hr>
			<p>율이는 순두부가 싫다.</p>
		</div>
		<div class="display_01">
			<h3>더원</h3>
			<hr>
			<p>율이는 짜장면이 질린다.</p>
		</div>
		<div class="display_01">
			<h3>이화식당</h3>
			<hr>
			<p>율이는 식당 아줌마가 싫다.</p>
		</div>
		<div class="display_01">
			<h3>영미분식</h3>
			<hr>
			<p>율이는 생각보다 좋아하는거 같다.</p>
		</div>
	</div>
	<footer> 개발자 정보: 조준곤 </footer>
</body>
</html>