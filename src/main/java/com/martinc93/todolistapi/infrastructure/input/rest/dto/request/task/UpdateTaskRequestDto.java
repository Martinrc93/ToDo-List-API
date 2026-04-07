package com.martinc93.todolistapi.infrastructure.input.rest.dto.request.task;

import com.martinc93.todolistapi.domain.model.task.vo.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record UpdateTaskRequestDto(

        @NotNull(message = "Task ID is required")
        @Positive(message = "Task ID must be a positive number")
        Long id,

        @NotBlank(message = "Title is required")
        @Size(min = 3, max = 50, message = "Title must be between 3 and 50 characters")
        String title,

        @NotBlank(message = "Description is required")
        String description,

        @NotNull(message = "Status is required")
        TaskStatus status
)
{ }
