package com.tud.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.tud.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	
	@GetMapping({ "", "/" })
	public String index(Model model) {
		model.addAttribute("boards", boardService.list()); // (key값,게시글목록) -> (list페이지로 boards가 날라감, 글목록 들고 오기)
		return "list";
	}
	
	
	@GetMapping({ "/writeForm" })
	public String writeForm() {
		return "board/writeForm"; // .jsp
	}
	

	@GetMapping({ "/edit" })
	public String edit() {
		return "editForm";
	}

}
