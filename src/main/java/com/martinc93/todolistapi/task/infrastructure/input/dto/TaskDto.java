package com.martinc93.todolistapi.task.infrastructure.input.dto;

import com.martinc93.todolistapi.task.domain.model.TaskStatus;

import java.time.LocalDateTime;

public record TaskDto(
        Long id,
        String description,
        TaskStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) { }
