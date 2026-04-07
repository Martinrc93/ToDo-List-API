package com.martinc93.todolistapi.infrastructure.input.rest.dto.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRequestDto(

        @NotBlank(message = "Username is required")
        String userName,

        //@NotBlank(message = "Email is required")
        //@Email
        String email,

        @NotBlank(message = "Password is required")
        String password
) {
}
