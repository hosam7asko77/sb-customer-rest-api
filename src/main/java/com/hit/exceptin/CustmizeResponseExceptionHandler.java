package com.hit.exceptin;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustmizeResponseExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex,WebRequest request){
		ExceptionResponse exeptionResponse=new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exeptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(CustomerNotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(Exception ex,WebRequest request){
		ExceptionResponse exeptionResponse=new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exeptionResponse,HttpStatus.NOT_FOUND);
	}
	@Override
	public final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders header,HttpStatus status,WebRequest request){
		ExceptionResponse exeptionResponse=new ExceptionResponse(new Date(),"Validation Failed", request.getDescription(false));
		return new ResponseEntity(exeptionResponse,HttpStatus.BAD_REQUEST);
	}
}
