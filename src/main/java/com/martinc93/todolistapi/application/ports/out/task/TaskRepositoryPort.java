package com.martinc93.todolistapi.application.ports.out.task;

import com.martinc93.todolistapi.domain.model.task.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskRepositoryPort {
    Task save(Task task);
    Task findById(Long id);
    Page<Task > findAll(Pageable pageable);
    void deleteById(Long id);
    Task update(Task task);
}
