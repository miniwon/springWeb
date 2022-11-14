<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05_review.jsp</title>
</head>
<body>
<h2>뷰페이지 지정 방식</h2>
<!-- 절대 경로를 작성하면 프로젝트명이 사라진다
	 절대 경로를 쓰려면 프로젝트명을 붙이거나
	 상대 경로를 쓰면 프로젝트명이 보인다 -->
<a href="/fSpringMVC/review/modelandview.do">1. ModelAndView</a><br>
<a href="review/string.do">2. 문자열 리턴</a><br>
<a href="review/void.do">3. void 리턴(요청명과 동일한 이름)</a><br>
</body>
</html>