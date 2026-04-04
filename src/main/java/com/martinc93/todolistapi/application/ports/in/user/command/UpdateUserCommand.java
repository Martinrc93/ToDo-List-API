package com.martinc93.todolistapi.application.ports.in.user.command;

public record UpdateUserCommand(
        Long id,
        String userName
) {
}
