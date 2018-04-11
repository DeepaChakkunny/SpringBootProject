package com.springboot.assignment.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.springboot.assignment.model.ExceptionResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;


@ControllerAdvice
public class ErrorHandlerController {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> generalException(Exception e){
		ExceptionResponse eR= new ExceptionResponse();
		eR.setCode(HttpStatus.BAD_REQUEST.value());
		eR.setMessage("Something has gone Wrong Please try after some time");
		return new ResponseEntity<>(eR,HttpStatus.BAD_REQUEST);
	} 	
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<ExceptionResponse> httpMediaTypeNotSupportedException(Exception e){
		ExceptionResponse eR= new ExceptionResponse();
		eR.setCode(HttpStatus.BAD_REQUEST.value());
		eR.setMessage("Invalid Media Type");
		return new ResponseEntity<>(eR,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<ExceptionResponse> numberFormatException(Exception e){
		ExceptionResponse eR= new ExceptionResponse();
		eR.setCode(HttpStatus.BAD_REQUEST.value());
		eR.setMessage("Invalid Request Parameter. Only numbers are accepted");
		return new ResponseEntity<>(eR,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ExceptionResponse> httpRequestMethodNotSupportedException(Exception e){
		ExceptionResponse eR= new ExceptionResponse();
		eR.setCode(HttpStatus.BAD_REQUEST.value());
		eR.setMessage("Request Method Not Supported");
		return new ResponseEntity<>(eR,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ExceptionResponse> requestParamException(Exception e) {
		ExceptionResponse eR= new ExceptionResponse();
		eR.setCode(HttpStatus.BAD_REQUEST.value());
		eR.setMessage("Invalid Request Parameter");
		return new ResponseEntity<>(eR,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ExceptionResponse> httpMessageNotReadableException(Exception e) {
		ExceptionResponse eR= new ExceptionResponse();
		eR.setCode(HttpStatus.BAD_REQUEST.value());
		eR.setMessage("Invalid/Empty Request Body");
		return new ResponseEntity<>(eR,HttpStatus.BAD_REQUEST);
	}


}
