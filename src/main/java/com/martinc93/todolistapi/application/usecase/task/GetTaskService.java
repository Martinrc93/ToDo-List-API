package com.martinc93.todolistapi.application.usecase.task;

import com.martinc93.todolistapi.application.ports.in.task.GetTaskUseCase;
import com.martinc93.todolistapi.application.ports.in.user.GetUserUseCase;
import com.martinc93.todolistapi.application.ports.out.task.TaskRepositoryPort;
import com.martinc93.todolistapi.domain.model.task.Task;
import com.martinc93.todolistapi.domain.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetTaskService implements GetTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;
/*
    @Override
    public Task getById(UUID id) {
        return taskRepositoryPort.findById(id);
    }
*/
    @Override
    public List<Task> getAll() {
        return taskRepositoryPort.findAll();
    }
}
