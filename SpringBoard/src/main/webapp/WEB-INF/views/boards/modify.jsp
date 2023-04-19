<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
	<h1>./boards/modify.jsp</h1>


<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">글 수정하기</h3>
	</div>
	<!-- action 속성이 없을때 : 자신의 주소 호출 -->
	<form role="form" method="post">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">글 번호</label> 
					<input type="text" class="form-control" id="exampleInputEmail1"
					value="${vo.bno }" name="bno" readonly>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">제목</label> 
					<input type="text" class="form-control" id="exampleInputEmail1"
					value="${vo.title }" name="title">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">작 성 자</label> 
					<input type="text" class="form-control" id="exampleInputPassword1"
					value="${vo.writer }" name="writer">
			</div>
			<div class="form-group">
				<label>내 용</label>
				<textarea class="form-control" rows="3"  name="content">${vo.content}</textarea>
			</div>
		</div>
	</form>
	
		<div class="box-footer">
			<button type="submit" class="btn btn-success">수정하기</button>
			<button type="submit" class="btn btn-danger">취소하기</button>
		</div>
</div>
<<script type="text/javascript">
	var formObj = $("form[role='form']")

	$(document).ready(function(){
		// 수정하기
		$(".btn-success").click(function(){
			formObj.submit();	
		});
		// 취소하기
		$(".btn-danger").click(function(){
			location.href="/boards/listALL";
		});
	});
</script>






<%@ include file="../include/footer.jsp"%>









