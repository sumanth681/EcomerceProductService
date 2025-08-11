package com.example.demo.exception;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;


@Getter
@Setter
public class CustomException {
    LocalDateTime timestamp;
    int status;
    String message;

    CustomException(LocalDateTime timestamp , int status , String message){
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }
}
