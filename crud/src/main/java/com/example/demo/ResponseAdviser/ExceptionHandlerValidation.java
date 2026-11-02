package com.example.demo.ResponseAdviser;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.Exception.UserNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerValidation {
	
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String, String> businessException(UserNotFoundException ex)
	{
		Map<String, String> errorMessage = new HashMap<>();
		errorMessage.put("errorMessage", ex.getMessage());
		return errorMessage;
	}

}
