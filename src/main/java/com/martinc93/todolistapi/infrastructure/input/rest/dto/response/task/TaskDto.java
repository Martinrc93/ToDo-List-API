package com.martinc93.todolistapi.infrastructure.input.rest.dto.response.task;

import com.martinc93.todolistapi.domain.model.task.vo.TaskStatus;

import java.time.LocalDateTime;

public record TaskDto(
        Long id,
        Long userId,
        String title,
        String description,
        TaskStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) { }
