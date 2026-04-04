package com.martinc93.todolistapi.infrastructure.input.rest.dto.request.user;

public record UserDto(
        String username,
        String password
) {
}
