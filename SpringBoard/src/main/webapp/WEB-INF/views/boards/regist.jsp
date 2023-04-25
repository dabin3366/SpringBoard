<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
	<h1>./boards/regist.jsp</h1>


<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">글쓰기</h3>
	</div>
	<!-- action 속성이 없을때 : 자신의 주소 호출 -->
	<form role="form" method="post">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">제목</label> 
					<input type="text" class="form-control" id="exampleInputEmail1"
					placeholder="제목을 작성하세요" name="title">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">작 성 자</label> 
					<input type="text" class="form-control" id="exampleInputPassword1"
					placeholder="작성자 이름을 작성하세요" name="writer">
			</div>
			<div class="form-group">
				<label>내 용</label>
				<textarea class="form-control" rows="3" placeholder="내용을 입력하세요" name="content"></textarea>
			</div>
		</div>
		<div class="box-footer">
			<button type="submit" class="btn btn-success">글쓰기</button>
		</div>
	</form>
</div>

<%@ include file="../include/footer.jsp"%>









