package com.example.demo.resources;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.InvalidDataException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.dtos.ErrorMessage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;

@ControllerAdvice
public class ApiExceptionHandler {
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ NotFoundException.class })
	@ResponseBody
	public ErrorMessage notFoundRequest(HttpServletRequest request, Exception exception) {
		return new ErrorMessage(exception.getMessage(), request.getRequestURI());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ 
		BadRequestException.class, 
		InvalidDataException.class,
		org.springframework.web.bind.MethodArgumentNotValidException.class
		})
	@ResponseBody
	public ErrorMessage badRequest(Exception exception) {
		return new ErrorMessage(exception.getMessage(), 
				exception.getCause() != null ? exception.getCause().getMessage() : "");
	}
}
