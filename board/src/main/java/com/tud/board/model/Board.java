package com.tud.board.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data				// getter setter 만들어준다.
@Builder 			// builder 만들어준다.
@NoArgsConstructor 	// 파라미터 없는 생성자 만들어준다.
@AllArgsConstructor // 모든 파라미터 대체해주는 생성자 만들어준다.
@Entity				// DB 바라보는 클래
public class Board {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 	//auto_increment
	private int id;
	

}
