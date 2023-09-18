package com.contentdata.rest;

import java.util.List;

import com.contentdata.dto.ErrorBO;
import com.contentdata.dto.ResponseBO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class GenericController {
	
	private static final String SUCCESS = String.valueOf(HttpStatus.OK.value());
	
	protected <T> ResponseEntity<ResponseBO<T>> sendResponse(T t){
		return new ResponseEntity<>(new ResponseBO<T>(t, null,SUCCESS),HttpStatus.OK);
	}
	
	public static <T> ResponseEntity<ResponseBO<T>> sendFailure(T t, List<ErrorBO> errors, int httpStatus){
		return new ResponseEntity<>(new ResponseBO<T>(t, errors,String.valueOf(httpStatus)),HttpStatus.resolve(httpStatus));
	}

}
