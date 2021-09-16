package com.tud.board.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tud.board.model.Board;
import com.tud.board.repository.BoardRepository;

// 스프링이 컴포넌트 스캔을 통해 Bean에 등록. -> IoC를 통해 메모리에 대신 띄워준다.
@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	


	@Transactional //서비스가 많은 경우 하나의 Transaction으로 묶임 + 정합성 유지 
	public void write(Board board) {	// title, content
		board.setCount(0);
		boardRepository.save(board);
	}
	
	public Page<Board> list(Pageable pageable){
		return boardRepository.findAll(pageable);
	}
	
}