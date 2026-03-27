package com.martinc93.todolistapi.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

    private String message;
    private int statusCode;
    private LocalDateTime timestamp;
    private Map<String,String>  errors;

    public ErrorMessage(String message, int statusCode){
        this.message = message;
        this.statusCode = statusCode;
        this.timestamp = LocalDateTime.now();
    }

}
