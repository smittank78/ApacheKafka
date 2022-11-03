package api.kafka.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController 
{
	@ExceptionHandler(Exception.class)
	public void exceptionHandle(Exception exception) 
	{
		System.out.println(exception);
	}
}
