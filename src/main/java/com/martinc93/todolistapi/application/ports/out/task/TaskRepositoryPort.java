package com.martinc93.todolistapi.application.ports.out.task;

import com.martinc93.todolistapi.domain.model.task.Task;

import java.util.List;
import java.util.UUID;

public interface TaskRepositoryPort {
    Task save(Task task);
    //Task findById(UUID id);
    List<Task > findAll();
}
