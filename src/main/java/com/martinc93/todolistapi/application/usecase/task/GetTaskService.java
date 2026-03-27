package com.martinc93.todolistapi.application.usecase.task;

import com.martinc93.todolistapi.application.ports.in.task.GetTaskUseCase;
import com.martinc93.todolistapi.application.ports.out.task.TaskRepositoryPort;
import com.martinc93.todolistapi.domain.model.task.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class GetTaskService implements GetTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Task getById(Long id) {
        return taskRepositoryPort.findById(id);
    }

    @Override
    public List<Task> getAll() {
        return taskRepositoryPort.findAll();
    }
}
