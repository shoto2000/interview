package com.common.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(SigninException.class)
	public ResponseEntity<ErrorDetails> signinExceptionHandler(SigninException e, WebRequest req) {

		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));

		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ErrorDetails> loginExceptionHandler(LoginException e, WebRequest req) {
		
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(LogoutException.class)
	public ResponseEntity<ErrorDetails> logoutExceptionHandler(LogoutException e, WebRequest req) {
		
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<ErrorDetails> studentExceptionHandler(StudentException e, WebRequest req) {
		
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(CourseException.class)
	public ResponseEntity<ErrorDetails> courseExceptionHandler(CourseException e, WebRequest req) {

		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));

		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> ExceptionHandler(Exception e, WebRequest req) {

		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));

		return new ResponseEntity<ErrorDetails>(err,HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
