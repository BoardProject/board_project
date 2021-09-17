<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp"%>

<div class="container">
<form>
	<input type="hidden" id="id" value="${board.id}"/>
		<div class="form-group">
			<label for="title">제목</label>
			<input value="${board.title}" type="text" class="form-control" placeholder="Enter Title" id="title">
		</div>

		<div class="form-group">
  <label for="content">내용</label>
  <textarea class="form-control summernote" rows="5" id="content">${board.content}</textarea>
</div>

	</form>
	<br/>
	<button id= "btn-edit" class="btn btn-primary">수정 완료</button>
</div>

<script>
      $('.summernote').summernote({
        placeholder: '내용을 입력하세요.',
        tabsize: 2,
        height: 300
      });
</script>
<br/><br/>

<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%> 