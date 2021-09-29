//object
let index = {
	init: function(){
		$("#btn-save").on("click" , ()=>{ // function(){} , ()=>{} 으로 쓰는 이유는 this를 바인딩하기 위해. function 사용하면 this 가 window 객체 가리켜 오류 날 수 있음
			this.save();
		});
		$("#btn-edit").on("click" , ()=> { 
			this.edit();
		});
		$("#btn-delete").on("click" , ()=> { 
			this.deleteById();
		});
	},

	
	save: function(){ // btn-save 클릭 시
		let data = {  //#id를 찾아서 그 id가 들고있는 값을 key에 넣어준다. from writeForm.jsp
				title: $("#title").val(),
				content: $("#content").val()
		};
		
		console.log(data);
		
		// ajax 호출 시 default가 비동기 호출
		// ajax 통신을 이용해서 데이터를 json으로 변경하여 insert 요청
		// ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환
		$.ajax({
			// 글쓰기 수행 요청
			type : "POST",
			url : "/api/board", // 요청을 주면 이 url로 요청하겠다.
			data : JSON.stringify(data),  // http body 데이터 , 밑에줄과 세트
			contentType : "application/json; charset=utf-8" , // body데이터가 어떤 타입인지(MIME type)
			dataType : "json" // 요청에 대한 응답이 왔을 때 기본적으로 모든 것이 문자열(생긴게 json이라면) => js object로 변경해줌.
		}).done(function(resp){ //응답 결과가 정상이면 done 실행
			alert("게시물 작성이 완료되었습니다.");
			location.href = "/";
		}).fail(function(error){ //응답결과 실패하면 fail 실행
			alert(JSON.stringify(error));
		}); // ajax 통신을 이용해서 받은 데이터를 json으로 변경하여 insert 요청
		
	},
	
	
	edit: function(){ 
		let id = $("#id").val();
		
		let data = {
				title: $("#title").val(),
				content: $("#content").val()
		};
	


		$.ajax({
			type : "PUT",
			url : "/api/board/"+id, 
			data : JSON.stringify(data), 
			contentType : "application/json; charset=utf-8" ,
			dataType : "json" 
		}).done(function(resp){
			console.log(id);
			console.log(data);
			alert("수정이 완료되었습니다.");
			location.href = "/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
		
	},
	
	
	
	deleteById: function(){
		let id = $("#id").text()
 
		$.ajax({
			type : "DELETE",
			url : "/api/board/"+id,
			dataType : "json"
		}).done(function(resp){
			alert("게시물이 삭제되었습니다.");
			location.href = "/";
		}).fail(function(error){ 
			alert(JSON.stringify(error));
		}); 
		
	},
	
}

// writeForm.jsp에서 하단에 script 읽어올때 init 함수 호출
index.init();