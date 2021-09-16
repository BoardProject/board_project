package com.tud.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class BoardController {

	@GetMapping({ "", "/" })
	public String index() {
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
