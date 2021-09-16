package com.tud.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tud.board.model.Board;

// findAll(), findbyId(), count(), save() 등
// DAO
// 자동 bean 등록 
// @Repository 생략 가능 
public interface BoardRepository extends JpaRepository<Board, Integer>{ // Board 테이블이 관리하는 repository의 primary key는 Integer
	

}
