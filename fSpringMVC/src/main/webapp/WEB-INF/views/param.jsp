<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>파람 복습</h3>
	<table border="2">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>나이</th>
		</tr>
			<tr>
				<td>${memberVO.name}</td>
				<td>${memberVO.id}</td>
				<td>${memberVO.age}</td>
			</tr>
	</table>
</body>
</html>