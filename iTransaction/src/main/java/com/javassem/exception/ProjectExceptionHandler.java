package com.javassem.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.javassem")
public class ProjectExceptionHandler {
	
	// 구체적인 예외를 작성
	@ExceptionHandler(Exception.class)
	public String handleExceString(Exception e, Model m) {
		
		m.addAttribute("exception", e);
		return "error/TransErrorPage";
	}

}
