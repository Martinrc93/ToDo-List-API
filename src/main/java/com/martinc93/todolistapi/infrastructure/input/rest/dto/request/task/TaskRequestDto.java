package com.martinc93.todolistapi.infrastructure.input.rest.dto.request.task;

public record TaskRequestDto(
        Long userId,
        String title,
        String description
) {
}
