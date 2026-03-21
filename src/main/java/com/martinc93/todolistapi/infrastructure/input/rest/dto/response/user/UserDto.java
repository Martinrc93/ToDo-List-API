package com.martinc93.todolistapi.infrastructure.input.rest.dto.response.user;

public record UserDto(
        String username,
        String email,
        String password
) {
}
