package com.martinc93.todolistapi.domain.exception.task;


import com.martinc93.todolistapi.domain.exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleAnyException(Exception ex){

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        ErrorMessage errorMessage = new ErrorMessage(
                ex.getMessage(),
                status.value()
        );
        return new ResponseEntity<>(errorMessage, status);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleTaskNotFoundException(TaskNotFoundException ex){
        HttpStatus status = HttpStatus.NOT_FOUND;

        ErrorMessage errorMessage = new ErrorMessage(
                ex.getMessage(),
                status.value()
        );
        return new ResponseEntity<>(errorMessage, status);
    }

}
