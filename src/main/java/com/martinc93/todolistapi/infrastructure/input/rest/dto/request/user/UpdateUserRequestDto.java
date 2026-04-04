package com.martinc93.todolistapi.infrastructure.input.rest.dto.request.user;

public record UpdateUserRequestDto(
        Long id,
        String userName
) {
}
