<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form>
		<div class="form-group">
			<label for="title">제목</label>
			<input type="text" class="form-control" placeholder="Enter Title" id="title">
		</div>

		<div class="form-group">

  <label for="content">내용</label>
  <textarea class="form-control summernote" rows="5" id="content"></textarea>
</div>

	</form>
	<br/>
	<button id= "btn-save" class="btn btn-primary">게시글 작성 완료</button>
</div>

<script>
$('.summernote').summernote({
placeholder: '내용을 입력하세요.',
tabsize: 2,
height: 300
});
</script>

<script src="/js/board.js"></script>

<%@ include file="../layout/footer.jsp"%> 

<<<<<<< HEAD
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%> 
=======
>>>>>>> 2b1af949f6b53fb485c89837f6b80dca8ec6093a
