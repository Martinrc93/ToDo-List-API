package com.martinc93.todolistapi.application.ports.in.task;

import com.martinc93.todolistapi.domain.model.task.Task;

public interface UpdateTaskUseCase {
    Task exucute (Task task);
}
