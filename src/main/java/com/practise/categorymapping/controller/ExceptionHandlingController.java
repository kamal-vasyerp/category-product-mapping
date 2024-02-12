package com.practise.categorymapping.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.practise.categorymapping.dto.ResponceDto;
import com.practise.categorymapping.exception.CategoryNotFoundException;
import com.practise.categorymapping.exception.ProductNotFoundException;

@RestControllerAdvice
public class ExceptionHandlingController {

	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value= {Exception.class})
	public ResponceDto GeneralException(Exception ex) {
		return new ResponceDto(500,"An general Exception was thrown.", ex.getMessage());
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value= {CategoryNotFoundException.class})
	public ResponceDto CategoryNotFoundExceptionHandler(CategoryNotFoundException ex) {
		return new ResponceDto(404,"Category was not available in the database.", ex.getStackTrace());
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value= {ProductNotFoundException.class})
	public ResponceDto ProductNotFoundExceptionHandler(ProductNotFoundException ex) {
		return new ResponceDto(404,"Product was not available in the database.", ex.getStackTrace());
	}
	
}
