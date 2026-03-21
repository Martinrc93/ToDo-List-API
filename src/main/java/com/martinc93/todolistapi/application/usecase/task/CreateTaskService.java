package com.martinc93.todolistapi.application.usecase.task;

import com.martinc93.todolistapi.application.ports.in.task.CreateTaskUseCase;
import com.martinc93.todolistapi.application.ports.out.task.TaskRepositoryPort;
import com.martinc93.todolistapi.domain.model.task.Task;
import com.martinc93.todolistapi.domain.model.task.vo.TaskStatus;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateTaskService implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    @Transactional
    public Task execute(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        task.setStatus(TaskStatus.PENDING);
        return taskRepositoryPort.save(task);
    }
}
