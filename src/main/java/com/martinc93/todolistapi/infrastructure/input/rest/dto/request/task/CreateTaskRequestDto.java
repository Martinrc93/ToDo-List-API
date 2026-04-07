package com.martinc93.todolistapi.infrastructure.input.rest.dto.request.task;

import jakarta.validation.constraints.NotBlank;

public record CreateTaskRequestDto(

        @NotBlank(message = "User ID is required")
        Long userId,

        @NotBlank(message = "Title is required")
        String title,

        @NotBlank(message = "Description is required")
        String description

) {
}
