<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!-- 각각의 페이지에서 추가하는 것보다, 공통의 페이지에서 인클루드 -->
<%@ include file="../include/header.jsp"%>



<h1>listALL.jsp</h1>


<%-- 	${result } --%>
${pageDTO }
<div class="box">
	<div class="box-header with-border">
		<h3 class="box-title">Bordered Table</h3>
	</div>
	<div class="box-body">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th style="width: 70px">글번호</th>
					<th>제목</th>
					<th>내용</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th style="width: 70px">조회수</th>
				</tr>
				<c:forEach var="vo" items="${boardList }">
					<tr>
						<td>${vo.bno }</td>
						<td>
						  <a href="/boards/read?bno=${vo.bno }">
							${vo.title }
						  </a>
						</td>
						<td>${vo.content }</td>
						<td>${vo.writer }</td>
						<td>${vo.regdate }</td>
						<td>
							<span class="badge bg-blue">
							 	${vo.viewcnt }
							</span>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="box-footer clearfix">
		<ul class="pagination pagination-sm no-margin pull-right">
			<c:if test="${pageDTO.prev }">
				<li><a href="/boards/listPage?page=${pageDTO.startPage-1 }">«</a></li>
			</c:if>
			
			<c:forEach var="idx" begin="${pageDTO.startPage }" end="${pageDTO.endPage }" step="1">
				<li
					<c:out value="${pageDTO.cri.page == idx? 'class=active':'' }"/>
				>
				<a href="/boards/listPage?page=${idx}">${idx }</a></li>
			</c:forEach>
			
			<c:if test="${pageDTO.next }">
				<li><a href="/boards/listPage?page=${pageDTO.endPage+1 }">»</a></li>
			</c:if>
		</ul>
	</div>
</div>

<!-- JSP페이지 실행순서 -->
<!-- JSP(JAVA) JSTL/EL HTML JS(AJAX) -->

<script type="text/javascript">
	var result = "${result}";
	
	if(result == "ok"){
		alert("정상적으로 글 작성 완료!");
	}
	if(result == "modOK"){
		alert("정상적으로 글 수정 완료!");
	}
	if(result == "delOK"){
		alert("정상적으로 글 삭제 완료!");
	}
	// alert("${result}");
	
</script>


<%@ include file="../include/footer.jsp"%>