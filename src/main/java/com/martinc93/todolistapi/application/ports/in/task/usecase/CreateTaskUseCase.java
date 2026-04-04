package com.martinc93.todolistapi.application.ports.in.task.usecase;

import com.martinc93.todolistapi.application.ports.in.task.command.CreateTaskCommand;
import com.martinc93.todolistapi.domain.model.task.Task;

public interface CreateTaskUseCase {
    Task execute(CreateTaskCommand command);
}
