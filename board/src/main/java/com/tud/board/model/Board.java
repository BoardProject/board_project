package com.tud.board.model;



import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data				// getter setter 만들어준다.
@Builder 			// builder 만들어준다.
@NoArgsConstructor 	// 파라미터 없는 생성자 만들어준다.
@AllArgsConstructor // 모든 파라미터 대체해주는 생성자 만들어준다.
@Entity				// DB 와 대응되 클래스 
public class Board {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 	//auto_increment
	private int id; // key값, 글번호 
	
	
	@Column(nullable = false, length = 100 )
	private String title; // 제목 
	
	
	@Lob	//대용량 데이터 
	private String content; // 내용 
	
	
	private int count; // 조회수 
	
	
	
	@CreationTimestamp
	private Timestamp createDate;



}
