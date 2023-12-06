package com.whatapp.message.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceCreationException.class)
    public ResponseEntity<ErrorResponse> resourceCreationException(ResourceCreationException exception, HttpServletRequest httpRequest){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setPathURI(String.valueOf(httpRequest.getRequestURI()));
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


//Duplicate resource
/*
* Duplicate resource
* Resouirce Not found
* MessageNot found
* User not found
* Duplicate User
*
* */