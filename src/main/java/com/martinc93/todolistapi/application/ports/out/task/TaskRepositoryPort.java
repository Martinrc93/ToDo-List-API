package com.martinc93.todolistapi.application.ports.out.task;

import com.martinc93.todolistapi.domain.model.task.Task;

import java.util.List;

public interface TaskRepositoryPort {
    Task save(Task task);
    Task findById(Long id);
    List<Task > findAll();
    void deleteById(Long id);
    Task update(Task task);
}
