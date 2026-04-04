package com.martinc93.todolistapi.infrastructure.input.rest.dto.request.user;

public record CreateUserRequestDto(
        String userName,
        String email,
        String password
) {
}
