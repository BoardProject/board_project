package com.tud.board.service;


import java.util.List;
import java.util.Optional;

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
	
	
	@Transactional(readOnly = true)
	public Page<Board> list(Pageable pageable){
		return boardRepository.findAll(pageable);
	}
	
	
	@Transactional(readOnly = true)
	public Board read(int id) {
		return boardRepository.findById(id)		//Optional 타입 리턴 
				.orElseThrow(()->{
					return new IllegalArgumentException("요청한 글이 없습니다.");
				});
	}
	
	
	public void edit(int id, Board requestBoard) { 
		Board board = boardRepository.findById(id) // 영속화
				.orElseThrow(()->{
					return new IllegalArgumentException("요청한 글이 없습니다.");
				});
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
		//해당 함수 종료 시(Sevice 종료될 때) 트랜잭션 종료 -> 더티체킹 - 자동 업데이트.(DB flush)
	}
	
	
	
	@Transactional
	public void delete(int id) {
		boardRepository.deleteById(id);  //deleteById는 원래 void method
	}
	
}