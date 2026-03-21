package com.martinc93.todolistapi.application.ports.in.task;

import com.martinc93.todolistapi.domain.model.task.Task;

import java.util.List;
import java.util.UUID;

public interface GetTaskUseCase {

    //Task getById(UUID id);

    List<Task> getAll();

}
