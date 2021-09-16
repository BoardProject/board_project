package com.tud.board.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.tud.board.dto.ResponseDto;

@ControllerAdvice // 어디서든 exception이 발생하면 이 클래스로 오게 하는 어노테이션
@RestController
public class GlobalExceptionHandler {

		@ExceptionHandler(value=IllegalArgumentException.class)
		public ResponseDto<String> handleArgumentException(IllegalArgumentException e) {
			return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
			
		}
}