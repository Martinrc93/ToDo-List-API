package com.martinc93.todolistapi.application.usecase.task;

import com.martinc93.todolistapi.application.ports.in.task.CreateTaskCommand;
import com.martinc93.todolistapi.application.ports.in.task.CreateTaskUseCase;
import com.martinc93.todolistapi.application.ports.out.task.TaskRepositoryPort;
import com.martinc93.todolistapi.application.ports.out.user.UserRepositoryPort;
import com.martinc93.todolistapi.domain.model.task.Task;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTaskService implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;

    @Override
    @Transactional
    public Task execute(CreateTaskCommand command) {

        userRepositoryPort.findById(command.userId());

        Task task = Task.create(
                command.userId(),
                command.title(),
                command.description()
        );
        return taskRepositoryPort.save(task);
    }
}
