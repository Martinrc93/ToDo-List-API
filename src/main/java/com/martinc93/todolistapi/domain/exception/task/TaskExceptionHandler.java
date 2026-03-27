package com.martinc93.todolistapi.domain.exception.task;


public class TaskExceptionHandler extends RuntimeException {
    public TaskExceptionHandler(String message) {
        super(message);
    }
}
