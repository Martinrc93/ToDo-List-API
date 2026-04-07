package com.martinc93.todolistapi.application.ports.in.task.usecase;

import com.martinc93.todolistapi.domain.model.task.Task;
import com.martinc93.todolistapi.domain.model.task.vo.TaskStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Optional;

public interface GetTaskUseCase {

    Optional<Task> getById(Long id);

    Page<Task> getAll(Pageable pageable);

    Page<Task> getByStatus(TaskStatus taskStatus, Pageable pageable);

    Page<Task> getByUpdatedAt(LocalDate from, LocalDate to, Pageable pageable);

}
