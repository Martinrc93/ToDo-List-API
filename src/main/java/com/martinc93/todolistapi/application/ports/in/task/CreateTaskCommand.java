package com.martinc93.todolistapi.application.ports.in.task;

public record CreateTaskCommand(
        Long userId,
        String title,
        String description
)
{}
