package com.example.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<CustomException> handleProductNotFoundException(ProductNotFoundException ex) {
          CustomException customException = new CustomException(LocalDateTime.now(), HttpStatus.NOT_FOUND.value() , ex.getMessage());
          return new  ResponseEntity<>(customException , HttpStatus.NOT_FOUND);
    }

}
