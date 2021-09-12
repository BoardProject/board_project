package com.tud.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {

	private long idx;
	private String title;
	private String content;
	private String writer;
	private int viewCnt;
	
	
	
	
}
