package com.martinc93.todolistapi.application.ports.out.task;

import com.martinc93.todolistapi.domain.model.task.Task;
import com.martinc93.todolistapi.domain.model.task.vo.TaskStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TaskRepositoryPort {
    Task save(Task task);
    Optional<Task> findById(Long id);
    Page<Task > findAll(Pageable pageable);
    Page<Task> findByTaskStatus(TaskStatus taskStatus, Pageable pageable);
    Page<Task> findByUpdatedAt(LocalDateTime from, LocalDateTime to,Pageable pageable);
    void deleteById(Long id);
    Task update(Task task);
}
