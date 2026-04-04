package com.martinc93.todolistapi.infrastructure.input.rest.dto.response.user;

public record UserReponseDto(
        Long id,
        String userName,
        String email
) {
}
