package com.martinc93.todolistapi.domain.exception.user;

import com.martinc93.todolistapi.domain.exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleUserNotFoundException(Exception ex){

        HttpStatus status = HttpStatus.NOT_FOUND;

        ErrorMessage errorMessage = new ErrorMessage(
                ex.getMessage(),
                status.value()
        );

        return new ResponseEntity<>(errorMessage, status);
    }
}
