<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>

<script type="text/javascript">
	var cnt = 1;
	
	function addFile(){
		$("#d_file").append("<input type='file' name='file"+cnt+"'> <br>");
		cnt++;
	}
</script>

</head>
<body>
	<h1>fileUpload.jsp</h1>
	
	<fieldset>
		<legend>다중파일 업로드</legend>
		<form method="post" enctype="multipart/form-data">
			<label>아이디</label>
			<input type="text" name="id"> <br>
			
			<label>이름</label>
			<input type="text" name="name"> <br>
			
			<input type="button" value="파일추가" onclick="addFile();">
			<hr>
			
			<div id="d_file">
			
			</div>
			
			<input type="submit" value="업로드">
		</form>
	</fieldset>
	
</body>
</html>