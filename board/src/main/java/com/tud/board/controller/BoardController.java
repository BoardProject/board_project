package com.tud.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@GetMapping({ "", "/" })
	public String index() {
		return "list"; // url 정해서 해야하나...index...?
	}

}
