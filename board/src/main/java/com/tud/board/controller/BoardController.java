package com.tud.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tud.board.dto.ResponseDto;
import com.tud.board.model.Board;
import com.tud.board.service.BoardService;


@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	
	// 메인 리스트 페이지 요청 
	@GetMapping({ "", "/" })
	public String index(Model model, @PageableDefault(size=5, sort="id",direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("boards", boardService.list(pageable)); // (key값,게시글목록) -> (list페이지로 boards가 날라감, 글목록 들고 오기)
		return "list";
	}
	
	
	
	// 게시물 작성 페이지 접속  
	@GetMapping({ "/writeForm" })
	public String writeForm() {
		return "board/writeForm"; // .jsp
	}
	
	
	

	// 게시물 수정 페이지 접속 
	@GetMapping({ "/editForm" })
	public String editForm() {
		return "editForm";
	}
	
	

	

}
