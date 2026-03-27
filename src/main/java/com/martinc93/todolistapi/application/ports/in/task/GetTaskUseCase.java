package com.martinc93.todolistapi.application.ports.in.task;

import com.martinc93.todolistapi.domain.model.task.Task;

import java.util.List;

public interface GetTaskUseCase {

    Task getById(Long id);

    List<Task> getAll();

}
