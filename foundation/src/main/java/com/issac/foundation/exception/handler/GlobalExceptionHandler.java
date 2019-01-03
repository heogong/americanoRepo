package com.issac.foundation.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.issac.foundation.exception.BaseException;  

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)  
    @ExceptionHandler(value = BaseException.class)  
    public String handleBaseException(BaseException e) {  
		
		logger.debug(e.getMessage());
		logger.error(e.getMessage());
		
		return e.getMessage();
    }  
  
//    @ExceptionHandler(value = Exception.class)
//    public String handleException(Exception e) {
//
//    	logger.debug(e.getMessage());
//    	logger.error(e.getMessage());
//
//    	return e.getMessage();
//    }
//
    @ExceptionHandler(value = NumberFormatException.class)  
    public String nfeHandler(NumberFormatException e){
    	
    	logger.debug(e.getMessage());
    	logger.error(e.getMessage());
        
    	return e.getMessage();  
    }
}

