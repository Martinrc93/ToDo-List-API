package com.martinc93.todolistapi.application.ports.in.task.command;

public record CreateTaskCommand(
        Long userId,
        String title,
        String description
)
{}
