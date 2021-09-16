<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>

<div class="container">
  <table class="table table-hover">
    <thead class="thead-dark">
      <tr>
        <th class="text-center">글 번호</th>
        <th class="text-center">제목</th>
        <th class="text-center">작성일</th>
        <th class="text-center">조회수</th>
      </tr>
    </thead>
   
	    <tbody>
	    <c:forEach var="board" items="${boards.content}">
	      <tr>
	        <td class="text-center">${board.id}</td>
	        <td class="text-center"><a href="/board/${board.id}" class="btn">${board.title}</a></td>
	        <td class="text-center">${board.createDate}</td>
	        <td class="text-center">${board.count}</td>

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