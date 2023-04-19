<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

	<h1>read.jsp</h1>

	<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">본문내용</h3>
	</div>
	
	<form role="form" method="post">
		<input type="hidden" name="bno" value="${resultVO.bno }"> 
	</form> 
	
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">제목</label> 
					<input type="text" class="form-control" id="exampleInputEmail1"
					name="title" value="${resultVO.title }" readonly>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">작 성 자</label> 
					<input type="text" class="form-control" id="exampleInputPassword1"
					value="${resultVO.writer }" name="writer" readonly>
			</div>
			<div class="form-group">
				<label>내 용</label>
				<textarea class="form-control" rows="3"  name="content" readonly>${resultVO.content }</textarea>
			</div>
		</div>
		<div class="box-footer">
			<button type="submit" class="btn btn-success">수정</button>
			<button type="submit" class="btn btn-warning">삭제</button>
			<button type="submit" class="btn btn-danger">목록</button>
		</div>
</div>
	<script type="text/javascript">
	$(document).ready(function(){
		// 글번호를 저장한 폼태그
		var formObj = $("form[role='form']");
		// alert(formObj);
		console.log(formObj);
		// 수정
		$(".btn-success").click(function(){
			// 수정 - 기존의 정보 출력(GET)
			// 폼태그 이동주소 설정 /boards/modify
			formObj.attr("action","/boards/modify");
			// 폼태그 이동방식 설정 GET
			formObj.attr("method","get");
			// 폼태그 정보 저장해서 페이지 이동
			formObj.submit();
		});
		// 목록
		$(".btn-danger").click(function(){
			location.href="/boards/listALL";
		});
		
		// 삭제
		$(".btn-warning").click(function(){
			formObj.attr("action","/boards/remove");
			formObj.submit();
		});
		
	});
	
	</script>













<%@ include file="../include/footer.jsp" %>