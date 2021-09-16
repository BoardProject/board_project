<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>

<div class="container">
  <table class="table">
    <thead class="thead-dark">
      <tr>
        <th>글 번호</th>
        <th>제목</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
    </thead>
   
	    <tbody>
	    <c:forEach var="board" items="${boards.content}">
	      <tr>
	        <td>${board.id}</td>
	        <td><a href="/board/${board.id}" class= "btn center">${board.title}</a></td>
	        <td>${board.createDate}</td>
	        <td>${board.count}</td>
	      </tr>
	    </c:forEach>
	    </tbody>
    
  </table>
  
<!-- block 속성의 pagination을 flex 통해 가운데로 옮기기 -->  
<ul class="pagination justify-content-center"> 
	<c:choose>
		<c:when test="${boards.first}">
			<li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
		</c:when>
		<c:otherwise>
			<li class="page-item"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${boards.last}">
			<li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
		</c:when>
		<c:otherwise>
			<li class="page-item"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
		</c:otherwise>
	</c:choose>

</ul>

</div>


<%@ include file="layout/footer.jsp"%> 