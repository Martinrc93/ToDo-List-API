package com.martinc93.todolistapi.infrastructure.input.rest.dto.request.task;

import com.martinc93.todolistapi.domain.model.task.vo.TaskStatus;

public record UpdateTaskRequestDto(
        Long id,
        String title,
        String description,
        TaskStatus status
)
{ }
