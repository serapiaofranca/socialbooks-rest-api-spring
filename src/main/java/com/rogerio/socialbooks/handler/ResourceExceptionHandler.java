package com.rogerio.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rogerio.socialbooks.services.exception.LivroNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<Void> handleLivroNaoEncontradoException( 
				LivroNaoEncontradoException e, HttpServletRequest request){
		
		return ResponseEntity.notFound().build();
	}		

}
