<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
request.do 결과<hr>
아이디: ${param.id}<br>
이름: ${vo.name} <br>
나이: ${vo.age} <br>
<hr>
<!-- 스프링은 원래 클래스명의 첫 글자를 소문자로 바꾼 게 객체 이름	 -->
아이디: ${memberVO.id}<br>
이름: ${memberVO.name} <br>
나이: ${memberVO.age} <br>
</body>
</html>