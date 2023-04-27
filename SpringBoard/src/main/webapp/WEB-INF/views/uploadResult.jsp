<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>uploadResult.jsp</h1>
	
	파라메터 정보 : ${paramMap } <br>
	파일 정보 : ${fileList } <br>
	
	사용자 아이디 : ${paramMap.id } <br>
	사용자 이름 : ${paramMap.name } <br>
	
	<c:forEach var="file" items="${fileList }">
		파일 정보 : <a href="/download?fileName=${file }">${file }</a> <br>
	</c:forEach>
	
	<c:forEach var="file" items="${fileList }">
		파일 확장자 : ${file.substring(file.lastIndexOf('.')) }
		<c:set var="tmp" value=" ${file.substring(file.lastIndexOf('.')) }"/>
		<c:if test="${tmp.equals('.txt')}">
			텍스트 파일 입니다
		</c:if>
		
		<c:if test="${!tmp.equals('.txt')}">
			<img src="/download?fileName=${file }">  <hr>
		</c:if>
	</c:forEach>
	
	<h2><a href="/fileUpload">파일업로드 하기</a></h2>
	
	<hr>
	
	<h3>이미지 썸네일</h3>
	<c:forEach var="file" items="${fileList }">
		파일 확장자 : ${file.substring(file.lastIndexOf('.')) }
		<c:set var="tmp" value=" ${file.substring(file.lastIndexOf('.')) }"/>
		<c:if test="${!tmp.equals('.txt')}">
			<img src="/thumb?fileName=${file }">  <hr>
		</c:if>
	</c:forEach>
	
</body>
</html>