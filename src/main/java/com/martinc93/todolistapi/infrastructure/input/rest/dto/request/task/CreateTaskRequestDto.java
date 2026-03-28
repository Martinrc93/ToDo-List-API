package com.martinc93.todolistapi.infrastructure.input.rest.dto.request.task;

public record CreateTaskRequestDto(
        Long userId,
        String title,
        String description
) {
}
