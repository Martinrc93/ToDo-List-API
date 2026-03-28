package com.martinc93.todolistapi.application.ports.in.task;

import com.martinc93.todolistapi.domain.model.task.vo.TaskStatus;

public record UpdateTaskCommand(
    Long id,
    String title,
    String description,
    TaskStatus status
) { }
