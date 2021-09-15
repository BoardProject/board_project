package com.tud.board.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tud.board.dto.ResponseDto;
import com.tud.board.model.Board;
import com.tud.board.service.BoardService;

@RestController
public class BoardApiController {

	@Autowired
	private BoardService boardService;

	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board) {
		boardService.글쓰기(board);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}


}