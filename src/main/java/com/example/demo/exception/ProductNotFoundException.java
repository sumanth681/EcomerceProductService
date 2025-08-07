package com.example.demo.exception;
import java.lang.RuntimeException;


public  class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}