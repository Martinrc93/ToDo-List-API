package com.martinc93.todolistapi.application.service.task;

import com.martinc93.todolistapi.application.ports.in.task.usecase.GetTaskUseCase;
import com.martinc93.todolistapi.application.ports.out.task.TaskRepositoryPort;
import com.martinc93.todolistapi.domain.model.task.Task;
import com.martinc93.todolistapi.domain.model.task.vo.TaskStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class GetTaskService implements GetTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Optional<Task> getById(Long id) {
        return taskRepositoryPort.findById(id);
    }

    @Override
    public Page<Task> getAll(Pageable pageable) {
        return taskRepositoryPort.findAll(pageable);
    }

    @Override
    public Page<Task> getByStatus(TaskStatus taskStatus, Pageable pageable) {
        return taskRepositoryPort.findByTaskStatus(taskStatus, pageable);
    }

    @Override
    public Page<Task> getByUpdatedAt(LocalDate from, LocalDate to, Pageable pageable) {

        LocalDateTime fromDate = from.atTime(LocalTime.MIN);
        LocalDateTime toDate = from.atTime(LocalTime.MAX);

        return taskRepositoryPort.findByUpdatedAt(fromDate, toDate, pageable);
    }
}
