package com.martinc93.todolistapi.application.usecase.task;

import com.martinc93.todolistapi.application.ports.in.task.UpdateTaskUseCase;
import com.martinc93.todolistapi.application.ports.out.task.TaskRepositoryPort;
import com.martinc93.todolistapi.domain.model.task.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateTaskService implements UpdateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Task exucute(Task task) {
        return taskRepositoryPort.update(task);
    }
}
