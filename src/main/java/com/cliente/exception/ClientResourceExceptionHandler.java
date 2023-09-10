package com.cliente.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ClientResourceExceptionHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<StandardError> clientNotFound(ClientNotFoundException clientNotFoundException,
                                                        HttpServletRequest httpServletRequest){
        StandardError standardError = new StandardError(HttpStatus.NOT_FOUND.value(), System.currentTimeMillis(),
                clientNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }
}
