package com.martinc93.todolistapi.application.service.task;

import com.martinc93.todolistapi.application.ports.in.task.command.CreateTaskCommand;
import com.martinc93.todolistapi.application.ports.in.task.usecase.CreateTaskUseCase;
import com.martinc93.todolistapi.application.ports.out.task.TaskRepositoryPort;
import com.martinc93.todolistapi.domain.model.task.Task;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTaskService implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    @Transactional
    public Task execute(CreateTaskCommand command) {

        Task task = Task.create(
                command.userId(),
                command.title(),
                command.description()
        );
        return taskRepositoryPort.save(task);
    }
}
