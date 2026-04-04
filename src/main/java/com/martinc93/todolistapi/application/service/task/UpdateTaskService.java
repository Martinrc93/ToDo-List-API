package com.martinc93.todolistapi.application.service.task;

import com.martinc93.todolistapi.application.ports.in.task.command.UpdateTaskCommand;
import com.martinc93.todolistapi.application.ports.in.task.usecase.UpdateTaskUseCase;
import com.martinc93.todolistapi.application.ports.out.task.TaskRepositoryPort;
import com.martinc93.todolistapi.domain.model.task.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateTaskService implements UpdateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Task exucute(UpdateTaskCommand command) {

        taskRepositoryPort.findById(command.id());

        Task task = Task.update(
                command.id(),
                command.title(),
                command.description(),
                command.status()
        );

        return taskRepositoryPort.update(task);
    }
}
