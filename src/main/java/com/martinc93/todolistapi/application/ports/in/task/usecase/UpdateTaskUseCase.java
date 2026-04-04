package com.martinc93.todolistapi.application.ports.in.task.usecase;

import com.martinc93.todolistapi.application.ports.in.task.command.UpdateTaskCommand;
import com.martinc93.todolistapi.domain.model.task.Task;

public interface UpdateTaskUseCase {
    Task exucute (UpdateTaskCommand command);
}
