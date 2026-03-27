package com.martinc93.todolistapi.application.ports.in.task;

import com.martinc93.todolistapi.domain.model.task.Task;
import com.martinc93.todolistapi.infrastructure.input.rest.dto.request.task.TaskRequestDto;

public interface CreateTaskUseCase {
    Task execute(CreateTaskCommand command);
}
