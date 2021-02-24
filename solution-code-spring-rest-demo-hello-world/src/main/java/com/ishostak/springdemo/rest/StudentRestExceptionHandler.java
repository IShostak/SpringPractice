package com.ishostak.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//aop advice to global exception handling

@ControllerAdvice
public class StudentRestExceptionHandler {

    //specific exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
        StudentErrorResponse response = new StudentErrorResponse();

        response.setMessage(ex.getMessage());
        response.setTimeStamp(System.currentTimeMillis());
        response.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    //generic exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
        StudentErrorResponse response = new StudentErrorResponse();

        response.setMessage(ex.getMessage());
        response.setTimeStamp(System.currentTimeMillis());
        response.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
