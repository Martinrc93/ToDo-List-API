package com.martinc93.todolistapi.domain.model.task.vo;

import java.util.UUID;

public record TaskId(UUID value) {

    public TaskId {
        if (value == null){
            throw new IllegalArgumentException("Task ID cannot be null");
        }
    }
}
