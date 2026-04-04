package com.martinc93.todolistapi.application.ports.in.user.command;

public record CreateUserCommand(
        String userName,
        String email,
        String password
) {
}
